package com.shop.tomford.report.query.getSoldReport;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.report.dto.SoldReportDto;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class GetSoldReportQueryHandler implements IRequestHandler<GetSoldReportQuery, List<SoldReportDto>> {
    private final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "soldReport", key = "#getSoldReportQuery.toString()")
    public HandleResponse<List<SoldReportDto>> handle(GetSoldReportQuery getSoldReportQuery) throws Exception {
        var startDate = getSoldReportQuery.getStartDate();
        var endDate = getSoldReportQuery.getEndDate();
        List<Tuple> soldReportList = orderRepository.getSoldReport(startDate, endDate);
        var soldReportDtoList = soldReportList.stream().map(tuple -> {
            var soldReportDto = new SoldReportDto();
            soldReportDto.setDate(tuple.get("date", Date.class));
            soldReportDto.setTotalOrder(Math.toIntExact(tuple.get("totalOrder", Long.class)));
            soldReportDto.setTotalRevenue(Math.toIntExact(tuple.get("totalRevenue", Long.class)));
            soldReportDto.setTotalQuantitySold(Math.toIntExact(tuple.get("totalQuantitySold", Long.class)));
            return soldReportDto;
        }).toList();
        return HandleResponse.ok(soldReportDtoList);
    }
}
