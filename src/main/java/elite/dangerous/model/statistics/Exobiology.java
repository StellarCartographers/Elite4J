/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.statistics;

import lombok.*;

@EliteCreator
@EliteObject
public class Exobiology
{
    private long organicGenusEncountered;
    private long organicSpeciesEncountered;
    private long organicVariantEncountered;
    private long organicDataProfits;
    private long organicData;
    private long firstLoggedProfits;
    private long firstLogged;
    private long organicSystems;
    private long organicPlanets;
    private long organicGenus;
    private long organicSpecies;
}
