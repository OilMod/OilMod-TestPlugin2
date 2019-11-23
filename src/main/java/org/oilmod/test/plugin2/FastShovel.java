package org.oilmod.test.plugin2;

import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IDurable;
import org.oilmod.api.items.type.IShovel;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.util.OilKey;

import static org.oilmod.api.rep.providers.minecraft.MinecraftItem.*;

public class FastShovel extends OilItem implements IShovel, IDurable {
    public FastShovel() {
        super(MinecraftItem.DIAMOND_SHOVEL, "I am so fast it hurts");
    }

    @Override
    public float getDestroySpeed(OilItemStack itemStack) {
        return 0.1f;
    }

    @Override
    public int getItemEnchantability() {
        return 10;
    }

    @Override
    public int getMaxDurability() {
        return 10;
    }
}
