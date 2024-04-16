package com.shop.tomford.promotion.command.tryDeletePromotion;

import com.shop.tomford.common.Cqrs.IRequest;

public record TryDeletePromotionCommand (int promotionId) implements IRequest<Void> {
}
