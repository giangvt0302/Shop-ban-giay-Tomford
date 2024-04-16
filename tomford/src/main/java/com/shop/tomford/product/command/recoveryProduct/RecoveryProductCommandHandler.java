package com.shop.tomford.product.command.recoveryProduct;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.repository.ProductOptionRepository;
import com.shop.tomford.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RecoveryProductCommandHandler implements IRequestHandler<RecoveryProductCommand, Void> {
    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(RecoveryProductCommand recoveryProductCommand) {
        productRepository.recoveryByProductId(recoveryProductCommand.product());
        return HandleResponse.ok();
    }
}
