package com.shop.tomford.report.query.getTopSoldProductReport;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.report.dto.ProductReportDto;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class GetTopSoldProductReportQuery implements IRequest<List<ProductReportDto>> {
   private Long startDateTimestamp;
 private    Long endDateTimeStamp;

    public Date getStartDate() {
        return startDateTimestamp == null ?null: new Date(startDateTimestamp);
    }

    public Date getEndDate() {
        return endDateTimeStamp == null ? null : new Date(endDateTimeStamp);
    }

}
