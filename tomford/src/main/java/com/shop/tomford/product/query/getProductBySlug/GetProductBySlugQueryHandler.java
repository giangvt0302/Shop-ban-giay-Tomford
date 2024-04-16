package com.shop.tomford.product.query.getProductBySlug;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.dto.ProductDetailDto;
import com.shop.tomford.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetProductBySlugQueryHandler implements IRequestHandler<GetProductBySlugQuery, ProductDetailDto> {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public HandleResponse<ProductDetailDto> handle(GetProductBySlugQuery getProductBySlugQuery) {
        var product = productRepository.findBySlug(getProductBySlugQuery.slug());
        if (product.isEmpty()) {
            return HandleResponse.ok(null);
        }
        return HandleResponse.ok(modelMapper.map(product.get(), ProductDetailDto.class));
    }
}
