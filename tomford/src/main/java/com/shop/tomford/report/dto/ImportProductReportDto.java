package com.shop.tomford.report.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ImportProductReportDto {
    private Date date;
    private int totalImport;
    private int totalCost;
    private int totalQuantityImport;
}
