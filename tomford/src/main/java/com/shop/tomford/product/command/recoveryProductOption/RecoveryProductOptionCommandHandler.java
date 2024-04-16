package com.shop.tomford.product.command.recoveryProductOption;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RecoveryProductOptionCommandHandler implements IRequestHandler<RecoveryProductOptionCommand, Void> {
    private final ProductOptionRepository productOptionRepository;

    @Transactional
    @Override
    public HandleResponse<Void> handle(RecoveryProductOptionCommand command) {

        productOptionRepository.recoveryByProductOptionId(command.productOptionId());
        return HandleResponse.ok();
    }
}
