package com.shop.tomford.stockReceipt.command.supplier.updateSupplier;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.stockReceipt.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UpdateSupplierCommandHandler implements IRequestHandler<UpdateSupplierCommand, Void> {
    private final SupplierRepository supplierRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public HandleResponse<Void> handle(UpdateSupplierCommand command) throws Exception {
        var exist = supplierRepository.findById(command.getSupplierId());
        if (exist.isEmpty()) {
            return HandleResponse.error("Không tìm thấy nhà cung cấp");
        }
        var supplier = exist.get();
        supplier.setName(command.getName());
        supplier.setAddress(command.getAddress());
        supplier.setEmail(command.getEmail());
        supplier.setPhone(command.getPhone());
        supplier.setDescription(command.getDescription());
        supplierRepository.save(supplier);
        return HandleResponse.ok();

    }
}
