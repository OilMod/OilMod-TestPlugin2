package org.oilmod.test.plugin2;

import org.oilmod.api.OilMod;
import org.oilmod.api.items.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by sirati97 on 16.01.2016.
 */
public class TestPlugin2 extends JavaPlugin {
    public static final Random rnd = new Random();
    private ItemRegistry itemRegistry;
    private static TestPlugin2 instance;
    private OilMod mod;

    @Override
    public void onEnable() {
        instance = this;
        mod = new OilMod("oiltest2");
        itemRegistry = new ItemRegistry(mod);
        itemRegistry.register(new FastPickaxe(mod.createKey("fast_pickaxe")));
        itemRegistry.register(new FastShovel(mod.createKey("fast_shovel")));
        itemRegistry.register(new FastAxe(mod.createKey("fast_axe")));
        itemRegistry.register(new BackpackItem(mod.createKey("backpack")));
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
