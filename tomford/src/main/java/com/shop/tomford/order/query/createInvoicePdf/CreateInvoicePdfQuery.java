package com.shop.tomford.order.query.createInvoicePdf;

import com.shop.tomford.common.Cqrs.IRequest;

public record CreateInvoicePdfQuery(String orderId) implements IRequest<String> {

}
