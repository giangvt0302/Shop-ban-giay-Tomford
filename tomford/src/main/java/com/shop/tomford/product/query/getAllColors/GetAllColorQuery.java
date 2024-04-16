package com.shop.tomford.product.query.getAllColors;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ColorDto;

import java.util.Collection;


public record GetAllColorQuery() implements IRequest<Collection<ColorDto>> {

}
