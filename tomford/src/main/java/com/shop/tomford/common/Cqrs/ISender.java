package com.shop.tomford.common.Cqrs;

public interface ISender {

    <TResponse>  HandleResponse<TResponse> send(IRequest<TResponse> request);

}


