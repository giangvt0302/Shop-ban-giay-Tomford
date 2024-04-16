package com.shop.tomford.report.query.getCategoryReport;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.report.dto.CategoryReportDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class GetReportByCategoryQuery implements IRequest<List<CategoryReportDto>> {
    private Long startDateTimestamp;
    private Long endDateTimeStamp;

    public Date getStartDate() {
        return startDateTimestamp == null ? null : new Date(startDateTimestamp);
    }

    public Date getEndDate() {
        return endDateTimeStamp == null ? null : new Date(endDateTimeStamp);
    }
}
