package com.shop.tomford.product.query.getProductById;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductDetailDto;


public record GetProductByIdQuery(int id) implements IRequest<ProductDetailDto> {

}
