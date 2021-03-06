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
package org.color4j.spectro.spi.helpers;

/**
 * This exception is thrown when Java Communication API
 * exception occurred
 */

public class CommDriverException extends Exception
{
    /**
     * Constructs an Exception without a message.
     */

    public CommDriverException()
    {
        super();
    }

    /**
     * Constructs an Exception with a detailed message.
     *
     * @param Message The message associated with the exception.
     */

    public CommDriverException( String message )
    {
        super( message );
    }
}
