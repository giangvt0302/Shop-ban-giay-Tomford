package com.shop.tomford.product.query.getAllSizes;

import com.shop.tomford.common.Cqrs.IRequest;

import java.util.Collection;


public record GetAllSizesQuery() implements IRequest<Collection<String>> {

}
