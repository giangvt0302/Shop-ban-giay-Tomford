package com.shop.tomford.product.query.getProductBySlug;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductDetailDto;


public record GetProductBySlugQuery(String slug) implements IRequest<ProductDetailDto> {

}
