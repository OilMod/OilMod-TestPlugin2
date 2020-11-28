package org.oilmod.test.plugin2.storage;

import org.oilmod.api.inventory.InventoryFactory;
import org.oilmod.api.inventory.ModInventoryObject;
import org.oilmod.api.items.ItemInteractionResult;
import org.oilmod.api.items.NMSItemStack;
import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IUnique;
import org.oilmod.api.rep.entity.EntityHumanRep;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.rep.world.WorldRep;
import org.oilmod.api.util.InteractionResult;
import org.oilmod.test.plugin2.PortableInventoryFilter;


public class StorageDiskItem extends OilItem implements IUnique {
    private final InventoryFactory.Builder<ModInventoryObject> invBuilder = InventoryFactory
            .builder("inv")
            .size(5)
            .standardTitle("storage disk internal inventory")
            .basic();

    public StorageDiskItem() {
        super(MinecraftItem.MUSIC_DISC_CAT, "Storage Disk");
    }

    @Override
    public OilItemStack createOilItemStackInstance(NMSItemStack nmsItemStack) {
        OilItemStack result = new OilItemStack(nmsItemStack, this);
        invBuilder.create(result);
        return result;
        //Uses custom itemstack class (for handling nbt/the inventory)
    }
}
