package org.oilmod.test.plugin2;

import org.bukkit.Material;
import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IAxe;
import org.oilmod.api.items.type.IDurable;
import org.oilmod.api.items.type.IShovel;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.util.OilKey;

public class FastAxe extends OilItem implements IAxe, IDurable {
    public FastAxe(OilKey key) {
        super(key, MinecraftItem.DIAMOND_SHOVEL.get().getItem(), "I am so axe it hurts");
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
}
