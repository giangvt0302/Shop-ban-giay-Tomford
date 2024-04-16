package com.shop.tomford.stockReceipt.command.supplier.deleteSupplier;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.stockReceipt.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeleteSupplierCommandHandler implements IRequestHandler<DeleteSupplierCommand, Void> {
    private final SupplierRepository supplierRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(DeleteSupplierCommand deleteSupplierCommand) throws Exception {
        var supplier = supplierRepository.findById(deleteSupplierCommand.supplierId());
        if (supplier.isEmpty()) {
            return HandleResponse.error("Không tìm thấy nhà cung cấp");
        }
        if (supplier.get().getStockReceipts().isEmpty()) {
            supplierRepository.hardDeleteById(deleteSupplierCommand.supplierId());
            return HandleResponse.ok();
        }
        supplierRepository.delete(supplier.get());

        return HandleResponse.ok();
    }
}
