package com.shop.tomford.promotion.query.getAllPromotions;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.promotion.PromotionDto;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
public class GetAllPromotionQuery extends PaginationRequest implements IRequest<Paginated<PromotionDto>> {
    private Long fromDateTimestamp;
    private Long toDateTimestamp;
    public LocalDateTime getFromDate() {
      return fromDateTimestamp != null ? Instant.ofEpochMilli(fromDateTimestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate().atStartOfDay() : null;
    }

    public LocalDateTime getToDate() {
        return toDateTimestamp != null ? Instant.ofEpochMilli(toDateTimestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate().atStartOfDay() : null;
    }


}
