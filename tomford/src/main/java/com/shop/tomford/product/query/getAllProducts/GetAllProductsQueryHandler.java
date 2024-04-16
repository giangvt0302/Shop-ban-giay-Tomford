package com.shop.tomford.product.query.getAllProducts;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.product.dto.ProductBriefDto;
import com.shop.tomford.product.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GetAllProductsQueryHandler implements IRequestHandler<GetAllProductsQuery, Paginated<ProductBriefDto>> {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<Paginated<ProductBriefDto>> handle(GetAllProductsQuery query) {

        String sortField = query.getSortField();
        if (sortField.isBlank()) {
            sortField = "created_date";
        }
        var paged = productRepository.simpleSearch(query.getKeyword(), query.getCategoryId(), query.getForGender(), query.getMinPrice(), query.getMaxPrice(), query.getPageable(sortField));

        var productBriefDtos = paged.map(product -> {
            return modelMapper.map(product, ProductBriefDto.class);
        });

        return HandleResponse.ok(Paginated.of(productBriefDtos));
    }
}
