package com.shop.tomford.category;

import com.shop.tomford.common.dto.AuditableDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryBriefDto extends AuditableDto{
    private int categoryId;
    private String name;
    private CategoryBriefDto parent;
}
