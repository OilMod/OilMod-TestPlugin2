package org.oilmod.test.plugin2;

import org.oilmod.api.OilMod;
import org.oilmod.api.inventory.ItemFilterRegistry;
import org.oilmod.api.items.ItemRegistry;
import org.oilmod.api.items.crafting.InterchangeableCraftingIngredient;
import org.oilmod.api.items.crafting.ItemCraftingFactory;
import org.oilmod.api.items.crafting.OilCraftingRecipe;
import org.oilmod.api.items.crafting.VanillaOilCraftingResult;
import org.oilmod.api.rep.providers.minecraft.MinecraftBlock;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;

import java.util.Random;

/**
 * Created by sirati97 on 16.01.2016.
 */
public class TestPlugin2 extends OilMod {
    public static final Random rnd = new Random();
    private static TestPlugin2 instance;

    public TestPlugin2() {
        super();
        instance = this;
    }

    @Override
    public void onRegisterItemFilter(ItemFilterRegistry registry) {
        registry.register("portable_inventory_filter", PortableInventoryFilter.INSTANCE);
    }

    @Override
    public void onRegisterItems(ItemRegistry itemRegistry) {
        System.out.println(itemRegistry);
        itemRegistry.register("fast_pickaxe", new FastPickaxe());
        itemRegistry.register("fast_shovel", new FastShovel());
        itemRegistry.register("fast_axe", new FastAxe());
        itemRegistry.register("backpack", new BackpackItem());
        itemRegistry.register("stick_flint", new StickFlintItem());
    }

    @Override
    public void onRegisterCraftingRecipes() {

        OilCraftingRecipe recipe;
        recipe = ItemCraftingFactory.createShapedRecipe(createKey("tester"), 1,2, new VanillaOilCraftingResult(MinecraftItem.ARROW.get().getItem()), new InterchangeableCraftingIngredient(MinecraftBlock.COBBLESTONE.get().getBlock().getItem(), MinecraftBlock.STONE.get().getBlock().getItem()), MinecraftBlock.OAK_PLANKS.get().getBlock().getItem());
        ItemCraftingFactory.registerGlobal(recipe);
    }

    public static TestPlugin2 getInstance() {
        return instance;
    }


    public static void printTrace(String text) {
        System.out.println("Printing stack trace for " + text + ":");
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (int i = 2; i < elements.length; i++) {
            StackTraceElement s = elements[i];
            System.out.println("\tat " + s.getClassName() + "." + s.getMethodName()
                    + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
        }
    }


}
