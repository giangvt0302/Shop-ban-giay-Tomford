package com.shop.tomford.rating.dto;

import com.shop.tomford.common.dto.AuditableDto;
import com.shop.tomford.product.dto.ProductOptionDto;
import com.shop.tomford.user.UserBriefDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto extends AuditableDto {
    private int id;
    private String content;
    private int value;
    private UserBriefDto user;
    private ProductOptionDto productOption;
}
