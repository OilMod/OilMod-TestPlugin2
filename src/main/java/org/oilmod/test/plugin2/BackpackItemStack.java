package org.oilmod.test.plugin2;

import org.bukkit.entity.Player;
import org.oilmod.api.inventory.InventoryFactory;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.items.NMSItemStack;
import org.oilmod.api.items.OilItemStack;

public class BackpackItemStack extends OilItemStack {
    private ModInventoryObject inventory;

    public BackpackItemStack(NMSItemStack nmsItemStack, BackpackItem item) {
        super(nmsItemStack, item);
        //Creates inventory attached to itemstack
        inventory = InventoryFactory.getInstance().createBasicInventory("inv", this, 27, "Backpack", PortableInventoryFilter.INSTANCE, true);
        //nbtName="inv",oilItemStack=this,size=3*9=27,title="Backpack",ItemFilter=PortableInventoryFilter.INSTANCE,mainInventory=true
    }

    @Override
    public BackpackItem getItem() {
        return (BackpackItem) super.getItem();
    }
}

