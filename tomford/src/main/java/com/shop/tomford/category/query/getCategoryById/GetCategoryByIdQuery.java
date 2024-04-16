package com.shop.tomford.category.query.getCategoryById;

import com.shop.tomford.category.CategoryDetailDto;
import com.shop.tomford.common.Cqrs.IRequest;

public record GetCategoryByIdQuery(int id) implements IRequest<CategoryDetailDto>{

}
