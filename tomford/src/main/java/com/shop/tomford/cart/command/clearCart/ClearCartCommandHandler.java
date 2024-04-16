package com.shop.tomford.cart.command.clearCart;

import com.shop.tomford.cart.CartRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.ICurrentUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClearCartCommandHandler implements IRequestHandler<ClearCartCommand, Integer> {
    private final CartRepository cartRepository;
    private final ICurrentUserService currentUserService;


    @Override
    @Transactional
    public HandleResponse<Integer> handle(ClearCartCommand clearCartCommand) {
        var currentUserId = currentUserService.getCurrentUserId();
        if (currentUserId.isEmpty()) {
            return HandleResponse.error("Bạn chưa đăng nhập");
        }
        return HandleResponse.ok(cartRepository.deleteAllByUserId(currentUserId.get()));
    }
}
