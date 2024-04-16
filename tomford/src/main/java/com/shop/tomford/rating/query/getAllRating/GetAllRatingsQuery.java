package com.shop.tomford.rating.query.getAllRating;


import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.rating.dto.RatingDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllRatingsQuery extends PaginationRequest implements IRequest<Paginated<RatingDto>> {

//    private Integer productId;
//    private

}
