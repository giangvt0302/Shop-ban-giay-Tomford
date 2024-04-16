package com.shop.tomford.stockReceipt.command.supplier.createSupplier;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.stockReceipt.entity.Supplier;
import com.shop.tomford.stockReceipt.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateSupplierCommandHandler implements IRequestHandler<CreateSupplierCommand, Integer> {
    private final SupplierRepository supplierRepository;

    @Override
    public HandleResponse<Integer> handle(CreateSupplierCommand createSupplierCommand) throws Exception {
        var supplier = Supplier.builder()
                .description(createSupplierCommand.getDescription())
                .phone(createSupplierCommand.getPhone())
                .email(createSupplierCommand.getEmail())
                .address(createSupplierCommand.getAddress())
                .name(createSupplierCommand.getName())
                .build();
        supplierRepository.save(supplier);
        return HandleResponse.ok(supplier.getSupplierId());

    }
}
