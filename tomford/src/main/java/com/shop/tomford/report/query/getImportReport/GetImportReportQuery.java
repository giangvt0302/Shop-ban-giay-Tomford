package com.shop.tomford.report.query.getImportReport;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.report.dto.ImportProductReportDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class GetImportReportQuery implements IRequest<List<ImportProductReportDto>> {
    private Long startDateTime;
    private Long endDateTime;

    public Date getStartDate() {
        return startDateTime == null ? null : new Date(startDateTime);
    }

    public Date getEndDate() {
        return endDateTime == null ? null : new Date(endDateTime);
    }

}
