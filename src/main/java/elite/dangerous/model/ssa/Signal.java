/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.ssa;

import lombok.*;

@EliteCreator
@EliteObject
public class Signal
{
    private String type;
    private long   count;
}
