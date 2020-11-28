package org.oilmod.test.plugin2.storage;

import org.oilmod.api.UI.*;
import org.oilmod.api.crafting.ICraftingProcessor;
import org.oilmod.api.data.IDataParent;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.items.OilBukkitItemStack;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.rep.entity.EntityHumanRep;
import org.oilmod.api.rep.entity.EntityPlayerRep;
import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.test.plugin2.TestPlugin2;

public class DiskContainerUI extends UIFactory<DiskContainerState> {
    public static final DiskContainerUI INSTANCE = new DiskContainerUI();

    private DiskContainerUI() {}

    @Override
    public UI<DiskContainerState> create(DiskContainerState state) {
        UI<DiskContainerState> ui = new UI<>(this, state);
        InventoryRep inv = state.getInventory();
        int offset = 0;

        ScrollbarElement scrollbar = new ScrollbarElement(UIMPI.getSizeSlots()*5+3,0, UIMPI.getSizeSlots()-2, 70, 0);


        for (ItemStackRep stack:inv.asIterable()) {
            if (stack instanceof OilBukkitItemStack) {
                OilItemStack oilItemStack = ((OilBukkitItemStack) stack).getOilItemStack();
                if (oilItemStack.getItem() instanceof StorageDiskItem) {
                    InventoryRep itemInv = oilItemStack.getInventory();
                    ui.addElement(new SlotPanel(scrollbar.getScrollDependent(0, 0, UIMPI.getSizeSlots()*offset++, UIMPI.getSizeSlots()), 1, itemInv.getSize(), 0, itemInv));
                }
            }
        }
        scrollbar.setMax(offset);
        scrollbar.setCurrentlyVisible(offset-2);
        ((FixedSize)scrollbar.getSize()).setHeight(offset*UIMPI.getSizeSlots());
        ui.addElement(scrollbar);

        return ui;
    }

    @Override
    public IDataParent getDataParent(DiskContainerState stack) {
        return stack;
    }

    @Override
    public IDataParent createDataParent(EntityPlayerRep player) {
        return TestPlugin2.DiskContainerInventoryType.get().create();
    }

    @Override
    public DiskContainerState getContext(IDataParent data) {
        return (DiskContainerState)data;
    }
}
