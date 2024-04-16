package com.shop.tomford.report.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Getter
@Setter
public class SoldReportDto {
    private Date date;
    private int totalOrder;
    private int totalRevenue;
    private int totalQuantitySold;

}
