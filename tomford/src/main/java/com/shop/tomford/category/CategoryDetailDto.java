package com.shop.tomford.category;

import com.shop.tomford.common.dto.AuditableDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryDetailDto extends AuditableDto {
    private int categoryId;
    private String name;
    private CategoryBriefDto parent;
    private List<CategoryDetailDto> children;
}
