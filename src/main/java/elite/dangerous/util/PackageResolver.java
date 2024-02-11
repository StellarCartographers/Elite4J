/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util;

import java.io.IOException;
import java.net.URL;

public interface PackageResolver
{
    /**
     * Returns an URL for a package
     * 
     * @param  pkg
     *                         the package (e.g. de.fhg.igd.CityServer3D)
     * 
     * @return             the URL to the package
     * 
     * @throws IOException
     *                         if the URL could not be retrieved
     */
    URL resolve(String pkg) throws IOException;
}
