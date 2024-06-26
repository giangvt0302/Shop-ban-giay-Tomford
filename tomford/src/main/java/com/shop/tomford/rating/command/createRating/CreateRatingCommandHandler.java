package com.shop.tomford.rating.command.createRating;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.CurrentUserService;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.product.repository.ProductOptionRepository;
import com.shop.tomford.rating.Rating;
import com.shop.tomford.rating.RatingRepository;
import com.shop.tomford.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class CreateRatingCommandHandler implements IRequestHandler<CreateRatingCommand, Integer> {
    private final OrderRepository orderRepository;
    private final RatingRepository ratingRepository;
    private final CurrentUserService currentUserService;
    private final ProductOptionRepository productOptionRepository;

    @Override
    @Transactional
    public HandleResponse<Integer> handle(CreateRatingCommand createRatingCommand) {
        var user = currentUserService.getCurrentUser();
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bạn chưa đăng nhập");
        }
        var order = orderRepository.findById(createRatingCommand.getOrderId());
        if (order.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn hàng không tồn tại");
        }
        var productOption = productOptionRepository.findById(createRatingCommand.getProductOptionId());
        if (productOption.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại");
        }

        var existingRating = ratingRepository.findFirstByUserIdAndProductOptionIdAndOrderId(((User) user.get()).getUserId(), createRatingCommand.getProductOptionId(), createRatingCommand.getOrderId());
        if (existingRating.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bạn đã đánh giá sản phẩm này");
        }
        var rating = Rating.builder().content(createRatingCommand.getContent()).value(createRatingCommand.getValue()).productOption(productOption.get()).order(order.get()).user((User) user.get()).build();
        ratingRepository.save(rating);
        return HandleResponse.ok(rating.getId());
    }
}
