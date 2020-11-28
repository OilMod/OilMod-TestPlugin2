package org.oilmod.test.plugin2.storage;

import org.oilmod.api.inventory.InventoryFactory;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.stateable.complex.ComplexStateTypeBase;

public class DiskContainerStateType extends ComplexStateTypeBase<DiskContainerState> {

    private final InventoryFactory.Builder<ModInventoryObject> invBuilder;

    public DiskContainerStateType() {
        super(DiskContainerState.class);
        invBuilder = InventoryFactory
                .builder("items")
                .standardTitle("Disk Drive")
                .size(4, 2)
                .filter(DiskOnlyFilter.INSTANCE)
                .mainInventory()
                .dropAll()
                .basic();
    }

    @Override
    public DiskContainerState create() {
        return new DiskContainerState(invBuilder);
    }
}
