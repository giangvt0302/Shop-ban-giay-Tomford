package com.shop.tomford.category.query.getAllCategories;

import com.shop.tomford.category.CategoryBriefDto;
import com.shop.tomford.category.CategoryRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.dto.Paginated;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetAllCategoriesQueriesHandler implements IRequestHandler<GetAllCategoriesQueries, Paginated<CategoryBriefDto>> {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public HandleResponse<Paginated<CategoryBriefDto>> handle(GetAllCategoriesQueries getAllCategoriesQueries) {
        var categories = categoryRepository.findAllByNameContainingIgnoreCase(getAllCategoriesQueries.getKeyword(),
                getAllCategoriesQueries.getPageable("categoryId"));
        return HandleResponse.ok(Paginated.of(categories.map(category -> modelMapper.map(category, CategoryBriefDto.class))));
    }

}
