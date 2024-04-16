package com.shop.tomford.product.dto;

import com.shop.tomford.common.dto.AuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductOptionDto extends AuditableDto {
    private int productOptionId;
    private String size;
    private int stock = 0;
    private LocalDateTime deletedDate = null;
    private ColorDto color;
}
