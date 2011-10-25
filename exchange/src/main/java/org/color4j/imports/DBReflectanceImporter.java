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

package org.color4j.imports;

import java.io.IOException;
import java.util.Map;
import org.color4j.colorimetry.entities.Reflectance;

/**
 */
public interface DBReflectanceImporter
{
    public String getName();

    public String getDefaultExtension();

    /**
     * @param user     set null if no username required.
     * @param password set null if no password required.
     * @param url
     *
     * @return
     *
     * @throws IOException
     * @throws ImportException
     */
    public Reflectance[] doImport( String user, String password, String url, Map<String, String> template )
        throws IOException, ImportException;
}
