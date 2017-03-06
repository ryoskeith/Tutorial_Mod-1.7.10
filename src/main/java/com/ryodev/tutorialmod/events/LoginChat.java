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

package com.ryodev.tutorialmod.events;

import com.ryodev.tutorialmod.handlers.ConfigurationHandler;
import com.ryodev.tutorialmod.reference.updateInfo;
import com.ryodev.tutorialmod.update.UpdateError;
import com.ryodev.tutorialmod.update.UpdateSuccess;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginChat
{
    boolean hasRunThisSession = false;

    @SubscribeEvent
    public void opPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        if (!hasRunThisSession)
        {
            if (ConfigurationHandler.updateCheck)
            {
                if (updateInfo.updateErrored)
                {
                    UpdateError.UpdateError(event);
                } else if (updateInfo.updateIsAvaiable)
                {
                    UpdateSuccess.updateSuccess(event);
                } else
                {

                }
                hasRunThisSession = true;
            } else
            {
                hasRunThisSession = true;
            }
        }
    }
}
