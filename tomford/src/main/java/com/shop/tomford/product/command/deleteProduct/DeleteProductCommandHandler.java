package com.shop.tomford.product.command.deleteProduct;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.repository.ProductOptionRepository;
import com.shop.tomford.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeleteProductCommandHandler implements IRequestHandler<DeleteProductCommand, Void> {
    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(DeleteProductCommand deleteProductCommand) {
        var product = productRepository.findById(deleteProductCommand.id());
        if (product.isEmpty()) {
            return HandleResponse.error("Không tìm thấy sản phẩm", HttpStatus.NOT_FOUND);
        }

        productRepository.delete(product.get());
        return HandleResponse.ok();
    }
}
