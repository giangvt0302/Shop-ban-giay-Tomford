package com.shop.tomford.report.dto;

import com.shop.tomford.product.dto.ProductBriefDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductReportDto {
    private ProductBriefDto product;
    private int totalSold;
    private int totalRevenue;
}
