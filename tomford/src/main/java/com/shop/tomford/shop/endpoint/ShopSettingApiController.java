package com.shop.tomford.shop.endpoint;

import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.shop.command.UpdateShopInfoCommand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/shop-setting")
@AllArgsConstructor
public class ShopSettingApiController {
    private final ISender sender;

    @PostMapping("/update")
    public ResponseEntity<Void> updateShopSetting(@Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody UpdateShopInfoCommand updateShopInfoCommand) {
        var result = sender.send(updateShopInfoCommand);
        result.orThrow();
        return ResponseEntity.ok().build();

    }

}
