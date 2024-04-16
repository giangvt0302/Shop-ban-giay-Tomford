package com.shop.tomford.product.query.getProductOptionsByListId;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductOptionDetailDto;

import java.util.List;


public record GetProductOptionsByListIdQuery(List<Integer> ids) implements IRequest<List<ProductOptionDetailDto>> {
}
