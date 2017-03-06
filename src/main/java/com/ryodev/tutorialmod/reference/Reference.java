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

package com.ryodev.tutorialmod.reference;

public class Reference
{
    public static final String MOD_ID = "TutorialMod";
    public static final String MOD_NAME = "Tutorial Mod";
    public static final String MOD_VERSION = "0.0.1";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[10.13.4.1614,)";
    public static final String MC_VERSION = "1.7.10";

    public static final String CLIENT_PROXY_CLASS = "com.ryodev.tutorialmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.ryodev.tutorialmod.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.ryodev.tutorialmod.client.gui.GuiFactory";

}
