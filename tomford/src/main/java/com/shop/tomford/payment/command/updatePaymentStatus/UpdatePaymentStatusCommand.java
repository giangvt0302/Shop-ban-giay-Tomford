package com.shop.tomford.payment.command.updatePaymentStatus;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.payment.entity.enums.PaymentStatus;

public record UpdatePaymentStatusCommand(String paymentId, PaymentStatus status) implements IRequest<Void> {
}
