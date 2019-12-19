package org.oilmod.test.plugin2;

import org.oilmod.api.inventory.InventoryFactory;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.items.NMSItemStack;
import org.oilmod.api.items.OilItemStack;

public class BackpackItemStack extends OilItemStack {
    private ModInventoryObject inventory;

    private final static InventoryFactory.Builder<ModInventoryObject> invBuilder = InventoryFactory
            .builder("inv")
            .chestSize(3)
            .standardTitle("Backpack")
            .filter(PortableInventoryFilter.INSTANCE)
            .mainInventory()
            .basic();


    public BackpackItemStack(NMSItemStack nmsItemStack, BackpackItem item) {
        super(nmsItemStack, item);
        //Creates inventory attached to itemstack
        inventory = invBuilder.create(this);
    }

    @Override
    public BackpackItem getItem() {
        return (BackpackItem) super.getItem();
    }
}

