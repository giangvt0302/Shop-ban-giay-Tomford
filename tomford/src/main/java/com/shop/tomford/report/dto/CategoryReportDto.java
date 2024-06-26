package com.shop.tomford.report.dto;

import com.shop.tomford.category.CategoryBriefDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryReportDto {
    private CategoryBriefDto category;
    private int totalProducts = 0;
    private int totalSoldProducts = 0;
    private double totalRevenue = 0;
}
