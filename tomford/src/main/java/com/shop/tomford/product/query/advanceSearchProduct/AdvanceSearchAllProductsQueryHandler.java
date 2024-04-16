package com.shop.tomford.product.query.advanceSearchProduct;

import com.shop.tomford.category.CategoryRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.product.dto.ProductBriefDto;
import com.shop.tomford.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class AdvanceSearchAllProductsQueryHandler implements IRequestHandler<AdvanceSearchAllProductsQuery, Paginated<ProductBriefDto>> {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<Paginated<ProductBriefDto>> handle(AdvanceSearchAllProductsQuery query) throws Exception {
        if (query.getSizes() != null)
            query.setSizes(Arrays.stream(query.getSizes()).map(String::toUpperCase).toArray(String[]::new));
        var categoryIds = categoryRepository.findAllByParentCategoryIdIn(query.getCategoryIds());
        if (query.getCategoryIds() != null) {
            categoryIds.addAll(Arrays.stream(query.getCategoryIds()).boxed().toList());
        }
        query.setCategoryIds(categoryIds.stream().mapToInt(Integer::intValue).toArray());
        if (query.getCategoryIds().length == 0) {
            query.setCategoryIds(null);
        }
        var productPage = productRepository.searchAllProducts(query.getKeyword(), query.getCategoryIds(), query.getForGenders(), query.getMinPrice(), query.getMaxPrice(), query.getColorIds(), query.getSizes(), query.getPageable("product.createdDate"));
        Paginated<ProductBriefDto> paginated = Paginated.of(productPage.map(product -> modelMapper.map(product, ProductBriefDto.class)));
        return HandleResponse.ok(paginated);
    }
}
