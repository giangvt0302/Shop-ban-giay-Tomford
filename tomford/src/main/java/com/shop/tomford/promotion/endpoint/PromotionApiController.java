package com.shop.tomford.promotion.endpoint;

import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.promotion.PromotionDto;
import com.shop.tomford.promotion.command.createPromotion.CreatePromotionCommand;
import com.shop.tomford.promotion.command.updatePromotion.UpdatePromotionCommand;
import com.shop.tomford.promotion.query.checkPromotion.CheckPromotionQuery;
import com.shop.tomford.promotion.query.getAllPromotions.GetAllPromotionQuery;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotion")
@AllArgsConstructor

public class PromotionApiController {
    private final ISender sender;
    @GetMapping("/check")
    public ResponseEntity<PromotionDto> checkPromotion(@Valid @ParameterObject CheckPromotionQuery checkPromotionQuery) {
       var result = sender.send(checkPromotionQuery);
         return ResponseEntity.ok(result.orThrow());
    }
    @GetMapping()
    public ResponseEntity<Paginated<PromotionDto>> getAllPromotions(@Valid @ParameterObject GetAllPromotionQuery query) {
       var result = sender.send(query);
         return ResponseEntity.ok(result.orThrow());
    }
    @PostMapping()
    public ResponseEntity<Integer> createPromotion(@Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody CreatePromotionCommand command) {
       var result = sender.send(command);
         return ResponseEntity.ok(result.orThrow());
    }

    @PutMapping()
    public ResponseEntity<Void> updatePromotion(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody @Valid UpdatePromotionCommand command) {
       var result = sender.send(command).orThrow();
         return ResponseEntity.ok().build();
    }

    @PatchMapping("/{promotionId}/toggleDisable")
    public ResponseEntity<Void> toggleDisablePromotion(@PathVariable Integer promotionId) {
       var result = sender.send(new com.shop.tomford.promotion.command.toggleDisablePromotion.ToggleDisablePromotion(promotionId));
         return ResponseEntity.ok(result.orThrow());
    }

    @DeleteMapping("/{promotionId}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> tryDeletePromotion(@PathVariable Integer promotionId) {
       var result = sender.send(new com.shop.tomford.promotion.command.tryDeletePromotion.TryDeletePromotionCommand(promotionId)).orThrow();
         return ResponseEntity.noContent().build();
    }

}
