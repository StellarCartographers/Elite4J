/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model;

import lombok.*;

import elite.dangerous.model.enums.ResourceCategory;

@EliteObject
@EliteCreator
public class MicroResource
{
    private String           name;
    private ResourceCategory category;
    private int              count;
}
