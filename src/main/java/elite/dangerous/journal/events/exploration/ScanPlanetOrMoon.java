/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.exploration;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.annotation.NonDefinedEvent;
import elite.dangerous.model.scan.*;

@EliteObject 
@NonDefinedEvent
public class ScanPlanetOrMoon extends Scan
{

    private double               axialTilt;

    private String               terraformState;

    private String               planetClass;

    private String               atmosphere;

    private String               atmosphereType;

    private String               volcanism;

    private String               reserveLevel;

    private double               massEM;

    private double               surfaceGravity;

    private double               surfacePressure;

    private int                  subclass;

    private boolean              tidalLock;

    private boolean              landable;

    private Parents              parents;

    private List<AtmosphereItem> atmosphereComposition;

    private List<Material>       materials;

    private Composition          composition;

}
