package com.shop.tomford.promotion.query.getPromotionById;

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
public class GetPromotionByIdQuery implements IRequest<PromotionDto> {
    private int promotionId;
}
