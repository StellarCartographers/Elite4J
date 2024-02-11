/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util;

import java.net.URL;

public class DefaultPackageResolver implements PackageResolver
{
    /**
     * @see PackageResolver#resolve(java.lang.String)
     */
    @Override
    public URL resolve(String pkg)
    {
        String package_path = pkg.replaceAll("\\.", "/");
        URL u = DefaultPackageResolver.class.getClassLoader().getResource(package_path);
        return u;
    }
}
