/*
 * Copyright (c) 2000-2011 Niclas Hedhman.
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
package org.color4j.exports.delimited;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;
import org.color4j.colorimetry.ColorException;
import org.color4j.colorimetry.Illuminant;
import org.color4j.colorimetry.Observer;
import org.color4j.colorimetry.Weights;
import org.color4j.colorimetry.encodings.DefaultEncodingFactory;
import org.color4j.colorimetry.encodings.EncodingFactory;
import org.color4j.colorimetry.weights.WeightsCache;
import org.color4j.colorimetry.encodings.CIELab;
import org.color4j.colorimetry.encodings.XYZ;
import org.color4j.colorimetry.Reflectance;
import org.color4j.colorimetry.illuminants.IlluminantImpl;
import org.color4j.colorimetry.observers.ObserverImpl;
import org.color4j.exports.AbstractReflectanceExporter;
import org.color4j.exports.TextFileReflectanceExporter;

public class ExporterXYZ_Lab extends AbstractReflectanceExporter implements TextFileReflectanceExporter
{
    private Illuminant m_Ill;
    private Observer m_Obs;
    private EncodingFactory factory = new DefaultEncodingFactory();

    public ExporterXYZ_Lab()
    {
        super( TextFileReflectanceExporter.XYZ_LAB, "txt" );
    }

    public void exportReflectances( Collection<Reflectance> reflectances, OutputStream out )
        throws IOException
    {
        if( reflectances != null && reflectances.size() > 0 )
        {
            XYZ wp = getWhitePoint();
            if( wp != null )
            {
                StringBuilder sb = new StringBuilder( 500 );
                sb.append( constructHeader() );
                DecimalFormat df = new DecimalFormat( "#.#####" );
                for( Reflectance r : reflectances )
                {
                    try
                    {
                        XYZ xyz = factory.createXYZ( m_Ill, r, m_Obs );
                        sb.append( r.getName() );
                        sb.append( ", " );
                        sb.append( df.format( xyz.getX() ) );
                        sb.append( ", " );
                        sb.append( df.format( xyz.getY() ) );
                        sb.append( ", " );
                        sb.append( df.format( xyz.getZ() ) );
                        sb.append( ", " );
                        CIELab lab = xyz.toCIELab( wp );
                        sb.append( df.format( lab.getL() ) );
                        sb.append( ", " );
                        sb.append( df.format( lab.geta() ) );
                        sb.append( ", " );
                        sb.append( df.format( lab.getb() ) );
                        sb.append( "\n" );
                    }
                    catch( ColorException e )
                    {
                        m_Logger.error( e.getMessage(), e );
                    }
                }
                out.write( sb.toString().getBytes() );
                sb.setLength( 0 );
            }
        }
    }

    private String constructHeader()
    {
        StringBuilder sb = new StringBuilder( 60 );
        try
        {

            sb.append( "Generated by Color4j.\n" );
            sb.append( new Date() );
            sb.append( "\nIlluminant: " );
            sb.append( m_Ill.getName() );
            sb.append( "\nObserver: " );
            sb.append( m_Obs.getName() );
            sb.append( '\n' );
            sb.append( "Name, XYZ_X, XYZ_Y, XYZ_Z, Lab_L, Lab_a, Lab_b\n" );
            return sb.toString();
        }
        finally
        {
            sb.setLength( 0 );
        }
    }

    // KH - Dec 16, 2004 : initializes the illuminant, observer, and whitepoint to use
    private XYZ getWhitePoint()
    {
        try
        {
            m_Ill = IlluminantImpl.create( getProperties().get( PROP_ILLUMINANT ).toString() );
            m_Obs = ObserverImpl.create( getProperties().get( PROP_OBSERVER ).toString() );
            Weights weights = WeightsCache.getInstance().getWeights( m_Ill, m_Obs );
            return weights.toWhitePoint();
        }
        catch( ColorException e )
        {
            m_Logger.error( e.getMessage(), e );
            throw e;
        }
    }

    public void resetState()
    {
    }

    public boolean requiresPrimary()
    {
        return false;
    }

    public boolean supportsMultipleColors()
    {
        return true;
    }

    public boolean supportsAttributes()
    {
        return false;
    }
}
