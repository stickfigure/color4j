/*
 * Copyright (c) 2011 Niclas Hedhman.
 *
 * Licensed  under the  Apache License, Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Created on Nov 7, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.color4j.spectro.drivers.xr;

import java.util.Map;
import org.color4j.spectro.spi.SpectroReading;
import org.color4j.spectro.spi.SpectroSettings;
import org.color4j.spectro.spi.SpectroStatus;

public class XR8000Reading implements SpectroReading
{
    SpectroStatus m_Status;
    Map m_Values;
    SpectroSettings m_Settings;

    public XR8000Reading( SpectroStatus status, SpectroSettings settings, Map values )
    {
        m_Status = status;
        m_Settings = settings;
        m_Values = values;
    }

    public SpectroStatus getStatus()
    {
        return m_Status;
    }

    public Map getValues()
    {
        return m_Values;
    }

    public SpectroSettings getSettings()
    {
        return m_Settings;
    }

    public void setSettings( SpectroSettings settings )
    {
        m_Settings = settings;
    }
}
