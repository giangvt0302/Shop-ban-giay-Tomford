package com.shop.tomford.payment.endpoint;

import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.payment.command.createPayment.CreatePaymentCommand;
import com.shop.tomford.payment.command.updatePaymentStatus.UpdatePaymentStatusCommand;
import com.shop.tomford.payment.dto.CreatePaymentResponse;
import com.shop.tomford.payment.dto.PaymentDto;
import com.shop.tomford.payment.query.getAllPayments.GetAllPaymentQuery;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor

public class PaymentApiController {
    private final ISender sender;

    @PostMapping("/create")
    @Secured("CAN_ORDER")
    public ResponseEntity<CreatePaymentResponse> createPayment(@Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody CreatePaymentCommand command) {
        return ResponseEntity.ok(sender.send(command).orThrow());
    }

    @PatchMapping("/update-status")
    @Secured("ORDER_MANAGEMENT")

    public ResponseEntity<Void> updatePaymentStatus(@Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody UpdatePaymentStatusCommand command) {
        sender.send(command).orThrow();
        return ResponseEntity.ok().build();
    }
    @GetMapping()
    @Secured("ADMIN_DASHBOARD")
    public ResponseEntity<Paginated<PaymentDto>> getAllPayment(@Valid @ParameterObject GetAllPaymentQuery query) {
     var result=   sender.send(query).orThrow();
        return ResponseEntity.ok(result);
    }

}
