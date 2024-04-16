package com.shop.tomford.promotion.command.createPromotion;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.promotion.Promotion;
import com.shop.tomford.promotion.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CreatePromotionCommandHandler implements IRequestHandler<CreatePromotionCommand, Integer> {
    private final PromotionRepository promotionRepository;

    @Override
    @Transactional
    public HandleResponse<Integer> handle(CreatePromotionCommand command) throws Exception {
        var exist = promotionRepository.findByCodeIgnoreCase(command.getCode());
        if (exist.isPresent()) {
            return HandleResponse.error("Code " + command.getCode() + " đã tồn tại");
        }
        var promotion = Promotion.builder()
                .active(command.isActive())
                .code(command.getCode())
                .endDate(command.getEndDate())
                .description(command.getDescription())
                .name(command.getName())
                .stock(command.getStock())
                .startDate(command.getStartDate())
                .discount(command.getDiscount())
                .maxValue(command.getMaxValue())
                .minOrderAmount(command.getMinOrderAmount())
                .type(command.getType())
                .build();
        promotionRepository.save(promotion);
        return HandleResponse.ok(promotion.getPromotionId());

    }
}
