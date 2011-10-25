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

/*
 * AltStandardParser.java
 *
 * Created on October 17, 2003, 11:34 AM
 */

package org.color4j.imports.xtf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.color4j.colorimetry.ReflectanceImpl;
import org.color4j.colorimetry.Spectrum;
import org.color4j.colorimetry.entities.Reflectance;
import org.color4j.imports.ImportException;
import org.color4j.imports.ini.AbstractGlobalsParser;
import org.color4j.imports.ini.AbstractSectionParser;
import org.color4j.imports.ini.ParserContext;

/**
 */
public class AltStandardParser extends AbstractSectionParser
{
    private static final Collection m_headers = new ArrayList();

    //must instatiate HEADERS from abstract class
    static
    {
        m_headers.add( XTFParserFactory.CUSTOMER );
        m_headers.add( XTFParserFactory.SAMPLE );
        m_headers.add( XTFParserFactory.ALT_STD );
    }

    /**
     * in section STANDARD, the STD key has 4 attributes, the first is name which is used in naming the reflectances
     * the following three are to be added to the globals map
     */
    public static final String NAME_PROPER = "NAME_PRIME";
    public static final String NAME_DESC = "NAME_DESC";
    public static final String NAME_DATE = "NAME_DATE";
    public static final String NAME_TIME = "NAME_TIME";
    public static final String ANGLES_KEY = "ANGLES";
    public static final String REFL_KEY = "REFL";
    public static final String STDNAME_KEY = "ALT STANDARD";
    public static final String TOLERANCE_KEY = "TOL";
    public static final String NOTES_KEY = "NOTE";

    public static final int REFLLOW = 400;  //same for all reflectances
    public static final int REFLHI = 700;   //same for all reflectances
    public static final int INTERVAL = 10;  //same for all reflectances
    public static final int REFLPTS = 31;   //same for all reflectances
    public static final String ANGLE_15 = "15";    //the following are for extending REFL keys
    public static final String ANGLE_25 = "25";
    public static final String ANGLE_45 = "45";
    public static final String ANGLE_75 = "75";
    public static final String ANGLE_110 = "110";
    public static final String EXCLUDED = "EXCLUDED";
    public static final String INCLUDED = "INCLUDED";

    private Map m_standards;
    private Map m_attributes;
    private int m_noteCounter;

/*    
    private String m_std;
    private String m_measurement;
    private List m_notes;
    private List m_tags;
    private List m_tols;

 */

    /**
     * Creates a new instance of StandardParser
     */
    public AltStandardParser()
    {
        initialize();
    }

    private void initialize()
    {
        m_standards = new HashMap();
        m_attributes = new HashMap();
        m_noteCounter = 1;
    }

    private void reset()
    {
        if( m_attributes != null )
        {
            m_attributes.clear();
        }
        if( m_standards != null )
        {
            m_standards.clear();
        }
/*        
        if(m_tols != null )
            m_tols.clear();
        if(m_notes != null )
            m_notes.clear();
        if(m_tags != null )
            m_tags.clear();
 */
        m_noteCounter = 1;

        /*
       m_std = null;
       m_measurement = null;
        */
    }

    /**
     * <PRE>
     * the logic of parsing this states body of key and values
     * </PRE>
     *
     * @throws ImportException if unexpected format found
     */
    public void processLine( String str, ParserContext ctx )
        throws ImportException
    {
        if( str == null || str.equals( "" ) )
        {
            return;
        }
        int pos = str.indexOf( '=' );
        if( pos < 0 )
        {
            throw new ImportException( "Invalid format:" + str );
        }
        String key = str.substring( 0, pos );
        String value = null;
        if( str.endsWith( "=" ) )
        {
            value = "N/A";
        }
        else
        {
            value = str.substring( pos + 1 );
        }

/*        
        char ch = key.charAt( 0 );
        
        if( ch == 'T' )
        {
            //handle tol tags
            if( key.charAt( 1 ) == 'O' )
            {
                processTolerance( key, value, m_attributes );
            }
            //handle tags
            else
            {
                List l = getTagList();
                l.add( value );
            }
                
        }
        else if( ch == 'N' )
        {
            getNotesList().add( value );
        }
        if( ch == 'S' )
        {
            m_std = value;
        }
        if( ch == 'M' )
        {
            m_measurement = value;
        }
        if( ch == 'R' )
        {
            String[] values = value.split( "`" );
            m_standards.put( values[0],  values );
        }
*/
        //process multiple REFL and TOL
        if( key.equals( REFL_KEY ) )
        {
            processReflectanceName( value, ctx, m_attributes, m_standards, XTFParserFactory.STANDARD, 0 );
        }
        else if( key.equals( TOLERANCE_KEY ) )
        {
            processTolerance( value, m_attributes );
        }
        else if( key.equals( NOTES_KEY ) && m_noteCounter++ > 1 )
        {
            m_attributes.put( NOTES_KEY + "_" + ( m_noteCounter - 1 ), value );
        }
        else
        {
            m_attributes.put( key, value );
        }
    }

    /**
     * will get a line with a reflectance and will add it to the reflectance map
     * according to provided documentation and add it to ParserContext's reflectance collection
     * 4 possible reflectance types based on ANGLES:
     * 1: a 0/45 or 45/0 instrument.  only 1 reflectance -- excluded specular, first entry is 0 ( indicates 45/0 or 0/45 )
     * 2: a sphere type instrument. two reflectances -- if first entry is 0, then specular is INCLUDED, if 1, then EXCLUDED
     * 3: multiangle instrument. three reflectances -- all exclude specular; if first entry is 0, then angle is 25, if entry is 1, then angle is 45, else if entry is 2, then angle is 75
     * 5: multiangle instrument. five reflectances -- same idea as angles, but starts with 15 and ends with 110
     *
     * @param value      value entry for key REFL
     * @param ctx        the current parser context
     * @param attributes attribute map for current section
     * @param standards  maps reflectances used for the section parser
     * @param type       a string for the type of reflectance, STANDARD, SAMPLE, MEASUREMENT; defined in SectionParser
     * @param index      an integer with a number, generally for the sample or measurement number; unused if type==STANDARD
     */
    protected static void processReflectanceName( String value,
                                                  ParserContext ctx,
                                                  Map attributes,
                                                  Map standards,
                                                  String type,
                                                  int index
    )
        throws ImportException
    {
        Map common = (Map) ctx.getGlobals().get( AbstractGlobalsParser.COMMON_MAP );
        String angle = (String) common.get( ANGLES_KEY );
        String name;

        //modifies name if sample
        if( type.equals( XTFParserFactory.SAMPLE ) )
        {
            name = (String) common.get( NAME_PROPER );
            name = name + "_" + XTFParserFactory.SAMPLE + "_" + index;
        }
        else
        {
            name = (String) attributes.get( STDNAME_KEY );
        }

        String[] parts = value.split( "`" );

        if( angle.equals( "1" ) )
        {
            if( parts[ 0 ].equals( "0" ) )
            {
                standards.put( name, value );
            }
            else
            {
                throw new ImportException( "Invalid reflectance format for " + name );
            }
        }
        else if( angle.equals( "2" ) )
        {
            if( parts != null && parts[ 0 ].equals( "0" ) )
            {
                standards.put( name + "_" + INCLUDED, value );
            }
            else if( parts != null && parts[ 0 ].equals( "1" ) )
            {
                standards.put( name + "_" + EXCLUDED, value );
            }
            else
            {
                throw new ImportException( "Invalid reflectance format for " + name );
            }
        }
        else if( angle.equals( "3" ) )
        {
            if( parts != null && parts[ 0 ].equals( "0" ) )
            {
                standards.put( name + "_" + ANGLE_25, value );
            }
            else if( parts != null && parts[ 0 ].equals( "1" ) )
            {
                standards.put( name + "_" + ANGLE_45, value );
            }
            else if( parts != null && parts[ 0 ].equals( "2" ) )
            {
                standards.put( name + "_" + ANGLE_75, value );
            }
            else
            {
                throw new ImportException( "Invalid reflectance format for " + name );
            }
        }
        else if( angle.equals( "5" ) )
        {
            if( parts != null && parts[ 0 ].equals( "0" ) )
            {
                standards.put( name + "_" + ANGLE_15, value );
            }
            else if( parts != null && parts[ 0 ].equals( "1" ) )
            {
                standards.put( name + "_" + ANGLE_25, value );
            }
            else if( parts != null && parts[ 0 ].equals( "2" ) )
            {
                standards.put( name + "_" + ANGLE_45, value );
            }
            else if( parts != null && parts[ 0 ].equals( "3" ) )
            {
                standards.put( name + "_" + ANGLE_75, value );
            }
            else if( parts != null && parts[ 0 ].equals( "4" ) )
            {
                standards.put( name + "_" + ANGLE_110, value );
            }
            else
            {
                throw new ImportException( "Invalid reflectance format for " + name );
            }
        }
        else
        {
            throw new ImportException( "Invalid reflectance format for " + name );
        }
    }

    /**
     * will get a line with a tolerance value and add it to the global map of attributes
     */
    private void processTolerance( String value, Map attributes )
    {
        String[] parts = value.split( "`" );
        attributes.put( TOLERANCE_KEY + "_" + parts[ 0 ], value );
    }

    /**
     * will setup reflectance and will call createReflectance to finish creation and add it to the parser context
     *
     * @param ctx       the parser context
     * @param standards map of standards
     */
    public static void createReflectance( ParserContext ctx,
                                          Map standards,
                                          Map attributes,
                                          Map<String, String> template,
                                          Map cachedKeys
    )
        throws ImportException
    {
        if( standards != null )
        {
            for( Object o : standards.entrySet() )
            {
                Map.Entry entry = (Map.Entry) o;
                String reflName = (String) entry.getKey();
                String refValue = (String) entry.getValue();

                Map conditions = new HashMap();
                //still needs to specify the Specular inclusion
                conditions.put( Reflectance.CONDITION_MODE, "Reflectance" );
                conditions.put( Reflectance.CONDITION_LIGHTFILTER, "UV Inc" );
                conditions.put( Reflectance.CONDITION_APERTURE, "MAV" );

                //32 is the limit of reflectance values, 31 for reflectances plus 1 for angle/spec
                String[] values = refValue.split( "`" );
                if( values != null )
                {
                    Map common = (Map) ctx.getGlobals().get( AbstractGlobalsParser.COMMON_MAP );
                    String angles = (String) common.get( ANGLES_KEY );
                    //check angle, then check 1st token to decide specular inclusion, then get 31 reflectance values.  if more or less, throw exception
                    //finish conditions map
                    if( angles.equals( "2" ) && values[ 0 ].equals( "0" ) )
                    {
                        conditions.put( Reflectance.CONDITION_SPECULAR, "SCI" );
                    }
                    else
                    {
                        conditions.put( Reflectance.CONDITION_SPECULAR, "SCE" );
                    }

                    //create the reflectance
                    try
                    {
                        //check first value and number of points
                        Integer angle = new Integer( values[ 0 ] );
                        ctx.getLogger()
                            .debug( "angle == " + angle.intValue() + " number of points == " + ( values.length - 1 ) );
                        if( ( angle.intValue() != 1 && angle.intValue() != 2 && angle.intValue() != 3 && angle.intValue() != 0 && angle
                                                                                                                                      .intValue() != 4 ) || values.length - 1 != REFLPTS )
                        {
                            throw new ImportException();
                        }

                        float[] nm = new float[ REFLPTS ];
                        float v;
                        //convert strings to float, start at index 1
                        for( int i = 1; i < values.length; i++ )
                        {
                            v = Float.parseFloat( values[ i ] );
                            if( v < 0 )
                            {
                                nm[ i - 1 ] = 0;
                            }
                            else
                            {
                                nm[ i - 1 ] = v / 100f;
                            }
                        }
                        Spectrum spectrum = Spectrum.create( REFLLOW, INTERVAL, nm );
                        Reflectance sample = ReflectanceImpl.create( spectrum, null, conditions );
//                        sample.setName( reflName );
                        //Map props = sample.getProperties(); 
                        //props.putAll( common );
                        //props.putAll( attributes );
                        Collection attrs = new ArrayList();
                        Iterator itr = common.entrySet().iterator();
                        while( itr.hasNext() )
                        {
                            Map.Entry me = (Map.Entry) itr.next();
                            String key = (String) me.getKey();
                            String value = (String) me.getValue();
//                            EntityAttribute attr = EntityAttributeUtil.createAttribute( sample, key, value, template, cachedKeys );
//                            attrs.add( attr );
                        }
                        itr = attributes.entrySet().iterator();
                        while( itr.hasNext() )
                        {
                            Map.Entry me = (Map.Entry) itr.next();
                            String key = (String) me.getKey();
                            String value = (String) me.getValue();
//                            EntityAttribute attr = EntityAttributeUtil.createAttribute( sample, key, value, template, cachedKeys );
//                            attrs.add( attr );
                        }
//                        sample.setEntityAttributes( attrs );
                        ctx.getReflectances().add( sample );
                    }
                    catch( NumberFormatException nfe )
                    {
                        throw new ImportException( "Invalid reflectance format for " + reflName );
                    }
                }
                else
                {
                    throw new ImportException( "Invalid reflectance format for " + reflName );
                }
            }
        }
    }

    /**
     * gets the <code>Collection</code> of <code>String</code>s of the next expected headers. Does not convert for caps
     * will look for indicated header, or proceed to EOF
     *
     * @return next expected String. no <b>null</b>
     */
    public Collection getValidHeaders()
    {
        return m_headers;
    }

    /**
     * after all the lines are processed do something useful with it before moving to next section
     * here, need to go through standards map and create the reflectances.  the first token is for the angle/specular
     */
    public void postProcess( ParserContext ctx, Map<String, String> attributes, Map cachedKeys )
        throws ImportException
    {
        createReflectance( ctx, m_standards, m_attributes, attributes, cachedKeys );
        //makeReflectance( ctx );
        reset();  //reset for future use
    }
}
