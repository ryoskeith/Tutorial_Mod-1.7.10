/***************************************************************************************************
 *
 * Copyright © 2017, Phoenix (Martin Keenan)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************************************/

package com.ryodev.tutorialmod;
//items
//blocks
//colored names for blocks and items
//tool enums
//tools
//ore dictionary
//language file
//crafting recipes
//crafting with ore dic
//plants
//food items
import com.ryodev.tutorialmod.events.LoginChat;
import com.ryodev.tutorialmod.handlers.ConfigurationHandler;
import com.ryodev.tutorialmod.init.InitItems;
import com.ryodev.tutorialmod.proxy.IProxy;
import com.ryodev.tutorialmod.reference.Reference;
import com.ryodev.tutorialmod.update.UpdateCheck;
import com.ryodev.tutorialmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = Reference.MOD_DEPENDENCIES, canBeDeactivated = true, guiFactory = Reference.GUI_FACTORY_CLASS)

public class TutoralMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static TutoralMod instance = new TutoralMod();

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("preInitialization Started");
        LogHelper.info("Reading config file");
        String configDir = event.getModConfigurationDirectory().toString();
        ConfigurationHandler.init(configDir);
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Checking for updates");
        UpdateCheck.checkForUpdates();
        FMLCommonHandler.instance().bus().register(new LoginChat());
        LogHelper.info("Register Items");
        InitItems.registerItems();
        LogHelper.info("preInitialization Complete");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("postInitialization Complete");
    }
}
