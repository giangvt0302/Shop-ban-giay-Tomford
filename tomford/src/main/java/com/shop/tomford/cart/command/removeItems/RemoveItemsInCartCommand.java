package com.shop.tomford.cart.command.removeItems;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class RemoveItemsInCartCommand implements IRequest<Void> {
    public List<Integer> productOptionIds = new ArrayList<>();
}
