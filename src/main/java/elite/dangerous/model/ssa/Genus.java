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

import com.fasterxml.jackson.annotation.JsonProperty;

@EliteCreator @EliteObject
public class Genus
{
    @JsonProperty("genus")
    private String name;
}
