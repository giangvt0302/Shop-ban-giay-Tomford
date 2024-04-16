package com.shop.tomford.product.query.getDeletedProductOptionsByProductId;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductOptionDto;

import java.util.List;

public record GetDeletedProductOptionsByProductId(int productId) implements IRequest<List<ProductOptionDto>> {
}
