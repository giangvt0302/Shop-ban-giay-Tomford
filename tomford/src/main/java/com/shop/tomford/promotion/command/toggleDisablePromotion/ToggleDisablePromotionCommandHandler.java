package com.shop.tomford.promotion.command.toggleDisablePromotion;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.promotion.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ToggleDisablePromotionCommandHandler implements IRequestHandler<ToggleDisablePromotion, Void> {
    private final PromotionRepository promotionRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(ToggleDisablePromotion command) throws Exception {
        var promotion = promotionRepository.findById(command.promotionId());
        if (promotion.isEmpty()) {
            return HandleResponse.error("Không tìm thấy mã giảm giá");
        }
        promotion.get().setActive(!promotion.get().isActive());
        return HandleResponse.ok();
    }
}
