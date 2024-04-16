package com.shop.tomford.cart.command.addToCart;

import com.shop.tomford.cart.CartItem;
import com.shop.tomford.cart.CartRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.ICurrentUserService;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AddToCartCommandHandler implements IRequestHandler<AddToCartCommand, Void> {
    private final CartRepository cartRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ICurrentUserService currentUserService;

    @Override
    @Transactional
    public HandleResponse<Void> handle(AddToCartCommand addToCartCommand) {
        var productOption = productOptionRepository.findById(addToCartCommand.getProductOptionId());
        if (productOption.isEmpty()) {
            return HandleResponse.error("Sản phẩm không tồn tại");
        }
        if (productOption.get().getStock() < addToCartCommand.getQuantity()) {
            return HandleResponse.error("Số lượng sản phẩm không đủ");
        }
        var currentUserId = currentUserService.getCurrentUserId();
        if (currentUserId.isEmpty()) {
            return HandleResponse.error("Bạn chưa đăng nhập");
        }
        var cartItem = CartItem.builder()
                .quantity(addToCartCommand.getQuantity())
                .userId(currentUserId.get())
                .productOptionId(addToCartCommand.getProductOptionId())
                .build();
        cartRepository.save(cartItem);
        return HandleResponse.ok();
    }
}
