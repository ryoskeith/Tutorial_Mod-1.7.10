package com.ryodev.tutorialmod.creativeTabs;

import com.ryodev.tutorialmod.init.InitItems;
import com.ryodev.tutorialmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ctabs
{
    public static CreativeTabs TutItems = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ":items.name") {
        @Override
        public Item getTabIconItem() {
            return InitItems.ingotCopper;
        }
    };
}
