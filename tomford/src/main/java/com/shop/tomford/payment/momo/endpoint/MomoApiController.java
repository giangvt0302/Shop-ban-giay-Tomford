package com.shop.tomford.payment.momo.endpoint;

import com.shop.tomford.payment.momo.MomoCallbackParam;
import com.shop.tomford.payment.momo.MomoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/momo")
@AllArgsConstructor
public class MomoApiController {
    private final MomoService momoService;


    @PostMapping("/ipn")
    public ResponseEntity<Void> ipn(MomoCallbackParam param) {
        System.out.println(param);
        return ResponseEntity.noContent().build();
    }
}