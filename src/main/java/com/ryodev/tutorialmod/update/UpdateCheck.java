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

package com.ryodev.tutorialmod.update;
import com.ryodev.tutorialmod.reference.Reference;
import com.ryodev.tutorialmod.reference.updateInfo;
import com.ryodev.tutorialmod.utility.LogHelper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UpdateCheck
{
    public static void checkForUpdates()
    {
        try {

            URL url = new URL(updateInfo.updatePath);
            HttpURLConnection connection = (HttpURLConnection) new URL(url.toString()).openConnection();
            connection.setRequestMethod("HEAD");
            int responceCode = connection.getResponseCode();
            LogHelper.info("UpdateChecker got responce " + responceCode);

            if(responceCode != 200)
            {
                updateInfo.updateErrored = true;
            }
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine())
            {
                updateInfo.modUpdate.add(scanner.nextLine());
            }
            scanner.close();

            updateInfo.updateArray = updateInfo.modUpdate.stream().toArray(String[]::new);

            if (!updateInfo.updateArray[0].startsWith("0"))
            {
                updateInfo.updateErrored = true;
            }
            else
            {
                if(!Reference.MOD_VERSION.endsWith(updateInfo.updateArray[0]))
                {
                    updateInfo.updateIsAvaiable = true;
                    updateInfo.updateLN1 = updateInfo.updateArray[1];
                    updateInfo.updateLN2 = updateInfo.updateArray[2];
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
