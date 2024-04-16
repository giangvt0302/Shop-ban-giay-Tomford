package com.shop.tomford.product.query.advanceSearchProduct;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.product.dto.ProductBriefDto;
import com.shop.tomford.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AdvanceSearchAllProductsQuery extends PaginationRequest implements IRequest<Paginated<ProductBriefDto>> {


    private int[] categoryIds;
    private Product.ProductGender[] forGenders;
    @Builder.Default
    private Integer minPrice = 0;
    @Builder.Default
    private Integer maxPrice = Integer.MAX_VALUE;
    private int[] colorIds;
    private String[] sizes;

}
