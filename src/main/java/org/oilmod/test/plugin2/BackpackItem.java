package org.oilmod.test.plugin2;

import com.google.common.base.Strings;
import org.oilmod.api.items.ItemInteractionResult;
import org.oilmod.api.items.NMSItemStack;
import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IUnique;
import org.oilmod.api.rep.entity.EntityHumanRep;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.rep.world.WorldRep;
import org.oilmod.api.util.InteractionResult;
import org.oilmod.api.util.OilKey;


public class BackpackItem extends OilItem implements IUnique {
    public BackpackItem(OilKey key) {
        super(key, MinecraftItem.LEATHER, "Backpack"); //defines Backpack item
        //Material=Material.LEATHER, MaterialData=0, ItemIdentifer="Backpack", MaxStackSize=1, DisplayName="Backpack"
    }

    @Override
    public BackpackItemStack createOilItemStackInstance(NMSItemStack nmsItemStack) {
        return new BackpackItemStack(nmsItemStack, this);
        //Uses custom itemstack class (for handling nbt/the inventory)
    }

    @Override
    public ItemInteractionResult onItemRightClick(OilItemStack stack, WorldRep world, EntityHumanRep human, boolean offhand) {
        String title = stack.getRename();
        stack.getMainInventory().setTitle(Strings.isNullOrEmpty(title)?"Backpack":title);
        human.openInventory(stack.getInventory());
        return new ItemInteractionResult(InteractionResult.SUCCESS, stack);
    }
}
