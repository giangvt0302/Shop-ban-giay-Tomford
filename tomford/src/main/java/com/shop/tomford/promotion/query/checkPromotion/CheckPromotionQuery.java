package com.shop.tomford.promotion.query.checkPromotion;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.promotion.PromotionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckPromotionQuery implements IRequest<PromotionDto> {
    private String code;
    private int orderValue;
}
