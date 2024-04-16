package com.shop.tomford.rating.query.getAllRating;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.product.repository.ProductOptionRepository;
import com.shop.tomford.rating.RatingRepository;
import com.shop.tomford.rating.dto.RatingDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GetAllRatingsQueryHandler implements IRequestHandler<GetAllRatingsQuery, Paginated<RatingDto>> {
    private final RatingRepository ratingRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<Paginated<RatingDto>> handle(GetAllRatingsQuery query) throws Exception {
//        var productOption = productOptionRepository.findById(getAllRatingOfProductIdQuery.getProductId());
//        if (productOption.isEmpty()) {
//            throw new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại");
//        }
//        var ratings = ratingRepository.findAllByProductOption(productOption.get(), getAllRatingOfProductIdQuery.getPageable("createdDate"));
//        var ratingDtos = ratings.map(rating -> modelMapper.map(rating, RatingDto.class));
        return null;
    }
}
