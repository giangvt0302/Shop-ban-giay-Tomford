package com.shop.tomford.rating.query.getAllRatingOfProductId;


import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.rating.dto.RatingDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllRatingOfProductIdQuery extends PaginationRequest implements IRequest<Paginated<RatingDto>> {

    private int productId;

}
