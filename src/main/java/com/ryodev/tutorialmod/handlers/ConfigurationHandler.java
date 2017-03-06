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

package com.ryodev.tutorialmod.handlers;

import com.ryodev.tutorialmod.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean updateCheck = true;

    public static void init(String configDir)
    {
        if (configuration == null)
        {
            File path = new File(configDir + "/" + Reference.MOD_ID + ".cfg");

            configuration = new Configuration(path);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        updateCheck = configuration.getBoolean("Check For Updates", Configuration.CATEGORY_GENERAL, true, "Allow this mod to check for updates.");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    public  static Configuration getConfiguration() {return  configuration;}
}
