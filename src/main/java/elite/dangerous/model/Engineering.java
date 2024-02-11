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

import java.util.List;

@EliteCreator @EliteObject
public class Engineering
{
    private String             engineer, blueprintName, experimentalEffect;
    private int                engineerID, blueprintID, level;
    private double             quality;
    private List<Modification> modifications;
}
