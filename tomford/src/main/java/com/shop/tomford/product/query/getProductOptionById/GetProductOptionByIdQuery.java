package com.shop.tomford.product.query.getProductOptionById;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductOptionDetailDto;


public record GetProductOptionByIdQuery(int id) implements IRequest<ProductOptionDetailDto> {
}
