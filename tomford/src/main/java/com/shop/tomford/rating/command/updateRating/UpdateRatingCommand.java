package com.shop.tomford.rating.command.updateRating;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRatingCommand implements IRequest<Void>
{
    private int id;
    private String content;
    @Min(value = 1, message = "Số sao không được để trống")
    private int value;

}
