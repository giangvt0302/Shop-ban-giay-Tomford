package com.shop.tomford.category.command.deleteCategory;

import com.shop.tomford.common.Cqrs.IRequest;


public record DeleteCategoryCommand(int id) implements IRequest<Void> {



}
