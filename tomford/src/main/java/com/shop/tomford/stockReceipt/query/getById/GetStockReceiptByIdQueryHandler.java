package com.shop.tomford.stockReceipt.query.getById;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.stockReceipt.dto.StockReceiptDetailDto;
import com.shop.tomford.stockReceipt.repository.StockReceiptRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GetStockReceiptByIdQueryHandler implements IRequestHandler<GetStockReceiptByIdQuery, StockReceiptDetailDto> {
    private final StockReceiptRepository stockReceiptRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<StockReceiptDetailDto> handle(GetStockReceiptByIdQuery getStockReceiptByIdQuery) {
        var stockReceipt = stockReceiptRepository.findById(getStockReceiptByIdQuery.id());
        if (stockReceipt.isEmpty()) {
            return HandleResponse.error("Không tìm thấy phiếu nhập", HttpStatus.NOT_FOUND);
        }
        var stockReceiptDetailDto = modelMapper.map(stockReceipt.get(), StockReceiptDetailDto.class);
        return HandleResponse.ok(stockReceiptDetailDto);
    }
}
