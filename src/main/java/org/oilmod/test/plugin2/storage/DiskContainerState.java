package org.oilmod.test.plugin2.storage;

import org.oilmod.api.data.DataParentImpl;
import org.oilmod.api.inventory.InventoryFactory;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.stateable.complex.IComplexStateType;
import org.oilmod.api.stateable.complex.IInventoryState;
import org.oilmod.test.plugin2.TestPlugin2;

public class DiskContainerState extends DataParentImpl implements IInventoryState {
    private ModInventoryObject inventory;


    public DiskContainerState(InventoryFactory.Builder<ModInventoryObject> invBuilder) {
        inventory = invBuilder.create(this);
    }

    public ModInventoryObject getModInventory() {
        return inventory;
    }

    @Override
    public IComplexStateType<DiskContainerState> getComplexStateType() {
        return TestPlugin2.DiskContainerInventoryType.get();
    }


    @Override
    public InventoryRep getInventory() {
        return inventory.getBukkitInventory();
    }

}
