package com.shop.tomford.cart.command.removeItem;

import com.shop.tomford.cart.CartRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.ICurrentUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RemoveItemFromCartCommandHandler implements IRequestHandler<RemoveItemFromCartCommand, Void> {
    private final CartRepository cartRepository;
    private final ICurrentUserService currentUserService;

    @Override
    @Transactional
    public HandleResponse<Void> handle(RemoveItemFromCartCommand removeItemFromCartCommand) {
        var currentUserId = currentUserService.getCurrentUserId();
        if (currentUserId.isEmpty()) {
            return HandleResponse.error("Bạn chưa đăng nhập");
        }
        var cartItem = cartRepository.findByUserIdAndProductOptionId(currentUserId.get(), removeItemFromCartCommand.productOptionId());
        if (cartItem.isEmpty()) {
            return HandleResponse.error("Sản phẩm không tồn tại trong giỏ hàng");
        }
        cartRepository.delete(cartItem.get());
        return HandleResponse.ok();
    }
}
