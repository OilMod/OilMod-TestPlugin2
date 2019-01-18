package org.oilmod.test.plugin2;

import org.bukkit.Material;
import org.oilmod.api.items.OilItem;
import org.oilmod.api.items.OilItemStack;
import org.oilmod.api.items.type.IAxe;
import org.oilmod.api.items.type.IDurable;
import org.oilmod.api.items.type.IPickaxe;
import org.oilmod.api.items.type.TBBType;
import org.oilmod.api.util.OilKey;

public class FastPickaxe extends OilItem implements IPickaxe, IDurable {
    public FastPickaxe(OilKey key) {
        super(key, Material.DIAMOND_PICKAXE, "I am so fast it hurts");
    }

    @Override
    public int getPickaxeStrength() {
        return 3;
    }

    @Override
    public float getDestroySpeed(OilItemStack itemStack) {
        return 1;
    }

    @Override
    public int getMaxDurability() {
        return 10;
    }

    @Override
    public int getItemEnchantability() {
        return 22;
    }
}
