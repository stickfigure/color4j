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

package org.color4j.spectro.drivers.sp68;

import org.color4j.spectro.spi.LensPosition;

public class UltraSmallAreaView implements LensPosition
{
    protected String m_DisplayName;
    protected String m_Name;
    protected double m_Radius;

    public UltraSmallAreaView()
    {
        m_DisplayName = "USAV";
        m_Name = "USAV";
        m_Radius = 4.0;
    }

    public String getName()
    {
        return m_Name;
    }

    public double getFocusRadius()
    {
        return m_Radius;
    }

    public String getDisplayName()
    {
        return m_DisplayName;
    }

    public String toString()
    {
        return m_DisplayName;
    }
}
