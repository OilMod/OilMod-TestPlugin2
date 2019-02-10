package org.oilmod.test.plugin2;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.oilmod.api.items.ItemInteractionResult;
import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IAxe;
import org.oilmod.api.items.type.IDurable;
import org.oilmod.api.items.type.IShovel;
import org.oilmod.api.util.InteractionResult;
import org.oilmod.api.util.OilKey;

public class FastAxe extends OilItem implements IAxe, IDurable {
    public FastAxe(OilKey key) {
        super(key, Material.DIAMOND_SPADE, "I am so axe it hurts");
    }

    @Override
    public float getDestroySpeed(OilItemStack itemStack) {
        return 22;
    }

    @Override
    public int getItemEnchantability() {
        return 100;
    }

    @Override
    public int getMaxDurability() {
        return 100;
    }

    @Override
    public InteractionResult onItemLeftClickOnBlock(OilItemStack stack, HumanEntity human, Location pos, boolean offhand, BlockFace facing, float hitX, float hitY, float hitZ) {
        human.sendMessage("onItemLeftClickOnBlock");
        return super.onItemLeftClickOnBlock(stack, human, pos, offhand, facing, hitX, hitY, hitZ);
    }

    @Override
    public InteractionResult onItemUseOnBlock(OilItemStack stack, HumanEntity human, Location pos, boolean offhand, BlockFace facing, float hitX, float hitY, float hitZ) {
        human.sendMessage("onItemUseOnBlock");
        return super.onItemUseOnBlock(stack, human, pos, offhand, facing, hitX, hitY, hitZ);
    }

    @Override
    public ItemInteractionResult onItemLeftClick(OilItemStack stack, World world, HumanEntity human, boolean offhand) {
        human.sendMessage("onItemLeftClick");
        return super.onItemLeftClick(stack, world, human, offhand);
    }

    @Override
    public ItemInteractionResult onItemRightClick(OilItemStack stack, World world, HumanEntity human, boolean offhand) {
        human.sendMessage("onItemRightClick");
        return super.onItemRightClick(stack, world, human, offhand);
    }
}
