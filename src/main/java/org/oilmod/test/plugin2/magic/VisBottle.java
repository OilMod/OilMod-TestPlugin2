package org.oilmod.test.plugin2.magic;

import org.oilmod.api.items.OilItem;
import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.util.OilKey;

public class VisBottle extends OilItem implements IVisContainer {
    public VisBottle(ItemProvider vanillaItem, String displayName) {
        super(MinecraftItem.POTION, "Vis Container");
    }
}
