package com.shop.tomford.category.query.getAllCategories;

import com.shop.tomford.category.CategoryBriefDto;
import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import lombok.*;


@Getter
public class GetAllCategoriesQueries extends PaginationRequest implements IRequest<Paginated<CategoryBriefDto>> {
}