package com.shop.tomford.promotion.command.toggleDisablePromotion;

import com.shop.tomford.common.Cqrs.IRequest;

public record ToggleDisablePromotion(int promotionId) implements IRequest<Void> {
}
