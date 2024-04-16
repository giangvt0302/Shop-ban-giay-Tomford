package com.shop.tomford.product.command.deleteProductOption;

import com.shop.tomford.cart.CartRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.order.repository.OrderItemRepository;
import com.shop.tomford.product.repository.ProductOptionRepository;
import com.shop.tomford.stockReceipt.repository.StockReceiptItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DeleteProductOptionCommandHandler implements IRequestHandler<DeleteProductOptionCommand, Void> {
    private final ProductOptionRepository productOptionRepository;
    private final OrderItemRepository orderItemRepository;
    private final StockReceiptItemRepository stockReceiptItemRepository;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(DeleteProductOptionCommand deleteProductOptionCommand) {
        var productOption = productOptionRepository.findById(deleteProductOptionCommand.id());
        if (productOption.isEmpty()) {
            return HandleResponse.error("Mẫu sản phẩm không tồn tại");
        }
        var canNotDelete = orderItemRepository.existsByProductOptionId(deleteProductOptionCommand.id()) ||
                stockReceiptItemRepository.existsByProductOptionId(deleteProductOptionCommand.id());
        if (canNotDelete) {
            System.out.println("soft delete");
            productOptionRepository.delete(productOption.get());

        } else {
            System.out.println("hard delete");

            productOptionRepository.hardDeleteById(deleteProductOptionCommand.id());
        }
        cartRepository.deleteAllByProductOptionIdIn(List.of(deleteProductOptionCommand.id()));
        return HandleResponse.ok();
    }
}
