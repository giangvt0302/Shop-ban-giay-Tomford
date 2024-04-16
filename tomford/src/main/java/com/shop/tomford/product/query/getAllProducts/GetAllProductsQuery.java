package com.shop.tomford.product.query.getAllProducts;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.product.dto.ProductBriefDto;
import com.shop.tomford.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllProductsQuery  extends PaginationRequest  implements IRequest<Paginated<ProductBriefDto>> {
    private Integer categoryId;
    private Product.ProductGender forGender;
    @Builder.Default
    private int minPrice = 0;
    @Builder.Default

    private int maxPrice = Integer.MAX_VALUE;
    @Builder.Default

    private boolean includeDeleted = false;
}
