package com.shop.tomford.payment.command.cancelOrderPayment;

import com.shop.tomford.common.Cqrs.IRequest;

public record CancelOrderPaymentCommand(String orderId) implements IRequest<Void> {
}
