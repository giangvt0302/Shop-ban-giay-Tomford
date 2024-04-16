package com.shop.tomford.payment.command.cancelExpiredPayment;

import com.shop.tomford.common.Cqrs.IRequest;



public record CancelExpiredPaymentCommand() implements IRequest<Void> {
}
