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
 * UCSCommand.java
 *
 * Created on March 18, 2007, 11:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.color4j.spectro.minolta.cm3600d;

import java.util.StringTokenizer;
import org.color4j.spectro.spi.LensPosition;
import org.color4j.spectro.spi.SpectroCommand;
import org.color4j.spectro.spi.SpectroEvent;

/**
 */
public class UCSCommand implements SpectroCommand, CommandStruc
{
    private LensPosition m_MeasureArea;
    private boolean m_Specular;
    private String m_CalibData;

    /**
     * Creates a new instance of UCSCommand
     */
    public UCSCommand( LensPosition measureArea, Boolean specular, String data )
    {
        m_MeasureArea = measureArea;
        m_Specular = specular.booleanValue();
        m_CalibData = data;
    }

    public String construct()
    {
        StringBuffer command = new StringBuffer( "UCS" );
        String m_valuesresult = "";

        if( m_Specular )
        {
            command.append( ",0" );
        }
        else
        {
            command.append( ",1" );
        }

        if( m_MeasureArea instanceof LargeAreaView )
        {
            command.append( ",0" );
        }
        else if( m_MeasureArea instanceof MediumAreaView )
        {
            command.append( ",1" );
        }
        else if( m_MeasureArea instanceof SmallAreaView )
        {
            command.append( ",2" );
        }

        command.append( "," + m_CalibData );
        command.append( DELIM );

        String cmd = command.toString();
        command = null;
        return cmd;
    }

    public String getName()
    {
        return "Set User Calibration Command";
    }

    public SpectroEvent interpret( byte[] valuesin )
    {
        String response = new String( valuesin );
        StringTokenizer sTok = new StringTokenizer( response, "," + DELIM );

        if( sTok.countTokens() == 1 )
        {
            String returnCode = sTok.nextToken();

            CM3600dStatus status = CM3600dStatus.create( returnCode );

            return new SpectroEvent( this, status );
        }
        else
        {
            CM3600dStatus errstatus = CM3600dStatus.create( "INVALID_RETURN" );
            return new SpectroEvent( this, errstatus );
        }
    }
}
