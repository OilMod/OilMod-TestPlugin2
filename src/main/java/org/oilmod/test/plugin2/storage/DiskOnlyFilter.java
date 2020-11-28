package org.oilmod.test.plugin2.storage;

import org.oilmod.api.inventory.ItemFilter;
import org.oilmod.api.items.OilBukkitItemStack;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.test.plugin2.BackpackItemStack;

public class DiskOnlyFilter implements ItemFilter {
    public final static DiskOnlyFilter INSTANCE = new DiskOnlyFilter();

    private DiskOnlyFilter() {    }

    @Override
    public boolean allowed(ItemStackRep itemStack) {
        if (itemStack instanceof OilBukkitItemStack) {
            OilItemStack oilItemStack = ((OilBukkitItemStack) itemStack).getOilItemStack();
            return oilItemStack.getItem() instanceof StorageDiskItem;
        }
        return false;
    }
}