package com.shop.tomford.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(assignableTypes  = org.springframework.stereotype.Controller.class)
public class MvcExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)  //handle this exception
    public String storageException(final ResponseStatusException throwable, final Model model) {
        model.addAttribute("message", throwable.getStatusCode().toString());
        model.addAttribute("status", throwable.getStatusCode().value());
        model.addAttribute("error", throwable.getReason());
        return "error";  //the html page in resources/templates folder
    }
}
