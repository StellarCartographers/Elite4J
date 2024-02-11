/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc.orders;

import java.util.function.Predicate;

@FunctionalInterface
public interface Legality<T>
{
    boolean isIllegal(T t);
    
    default Predicate<T> asPredicate() {
        return t -> isIllegal(t);
    }
}