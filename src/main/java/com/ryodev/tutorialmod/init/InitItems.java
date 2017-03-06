package com.ryodev.tutorialmod.init;


import com.ryodev.tutorialmod.items.base.BaseItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitItems
{
    public static final BaseItem ingotCopper = new Ingots("ingotCopper");


    public static void registerItems()
    {
        GameRegistry.registerItem(ingotCopper, "ingotCopper");
    }
}
