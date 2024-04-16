package com.shop.tomford.common.Cqrs;

public interface IRequestHandler<TRequest, TResponse> {
    HandleResponse<TResponse> handle(TRequest request) throws Exception;

}