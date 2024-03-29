/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.other;

import lombok.*;

import elite.dangerous.journal.Event;
import elite.dangerous.model.Fuel;

@EliteObject 
public class Status extends Event
{
    private static final int      FLAG_DOCKED                       = 0x00000001;

    private static final int      FLAG_LANDED                       = 0x00000002;

    private static final int      FLAG_LANDING_GEAR_DOWN            = 0x00000004;

    private static final int      FLAG_SHIELDS_UP                   = 0x00000008;

    private static final int      FLAG_SUPERCRUISE                  = 0x00000010;

    private static final int      FLAG_FLIGHT_ASSIST_OFF            = 0x00000020;

    private static final int      FLAG_HARDPOINTS_DEPLOYED          = 0x00000040;

    private static final int      FLAG_IN_WING                      = 0x00000080;

    private static final int      FLAG_LIGHTS_ON                    = 0x00000100;

    private static final int      FLAG_CARGO_SCOOP_DEPLOYED         = 0x00000200;

    private static final int      FLAG_SILENT_RUNNING               = 0x00000400;

    private static final int      FLAG_SCOOPING_FUEL                = 0x00000800;

    private static final int      FLAG_SRV_HANDBRAKE                = 0x00001000;

    private static final int      FLAG_SRV_USING_TURRET_VIEW        = 0x00002000;

    private static final int      FLAG_SRV_TURRET_RETRACTED         = 0x00004000;

    private static final int      FLAG_SRV_DRIVE_ASSIST             = 0x00008000;

    private static final int      FLAG_FSD_MASS_LOCKED              = 0x00010000;

    private static final int      FLAG_FSD_CHARGING                 = 0x00020000;

    private static final int      FLAG_FSD_COOLDOWN                 = 0x00040000;

    private static final int      FLAG_LOW_FUEL                     = 0x00080000;

    private static final int      FLAG_OVER_HEATING                 = 0x00100000;

    private static final int      FLAG_HAS_LAT_LONG                 = 0x00200000;

    private static final int      FLAG_IS_IN_DANGER                 = 0x00400000;

    private static final int      FLAG_BEING_INTERDICTED            = 0x00800000;

    private static final int      FLAG_IN_MAIN_SHIP                 = 0x01000000;

    private static final int      FLAG_IN_FIGHTER                   = 0x02000000;

    private static final int      FLAG_IN_SRV                       = 0x04000000;

    private static final int      FLAG_HUD_IN_ANALYSIS_MODE         = 0x08000000;

    private static final int      FLAG_NIGHT_VISION                 = 0x10000000;

    private static final int      FLAG_ALTITUDE_FROM_AVERAGE_RADIUS = 0x20000000;

    private static final int      FLAG_FSD_JUMP                     = 0x40000000;

    private static final int      FLAG_SRV_HIGH_BEAM                = 0x80000000;

    private static final int      FLAG2_ON_FOOT                     = 0x0001;

    private static final int      FLAG2_IN_TAXI                     = 0x0002;

    private static final int      FLAG2_IN_MULTICREW                = 0x0004;

    private static final int      FLAG2_ON_FOOT_IN_STATION          = 0x0008;

    private static final int      FLAG2_ON_FOOT_ON_PLANET           = 0x0010;

    private static final int      FLAG2_AIM_DOWN_SIGHT              = 0x0020;

    private static final int      FLAG2_LOW_OXYGEN                  = 0x0040;

    private static final int      FLAG2_LOW_HEALTH                  = 0x0080;

    private static final int      FLAG2_COLD                        = 0x0100;

    private static final int      FLAG2_HOT                         = 0x0200;

    private static final int      FLAG2_VERY_COLD                   = 0x0400;

    private static final int      FLAG2_VERY_HOT                    = 0x0800;

    private static final int      FLAG2_GLIDE_MODE                  = 0x1000;

    private static final int      FLAG2_ON_FOOT_IN_HANGAR           = 0x2000;

    private static final int      FLAG2_ON_FOOT_SOCIAL_SPACE        = 0x4000;

    private static final int      FLAG2_ON_FOOT_EXTERIOR            = 0x8000;

    private static final int      FLAG2_BREATHABLE_ATMOSPHERE       = 0x00010000;

    private static final String[] GUI_FOCUS                         = {"NoFocus", "InternalPanel", "ExternalPanel", "CommsPanel", "RolePanel", "StationServices", "GalaxyMap", "SystemMap", "Orrery", "FSS mode", "SAA mode", "Codex"};

    private int                   flags;

    private int                   flags2;

    public Fuel                   fuel;

    private double                cargo;

    private String                legalState;

    private int                   guiFocus;

    private int                   fireGroup;

    private int[]                 pips;

    private double                altitude;

    private double                latitude;

    private double                longitude;

    private double                heading;

    private String                bodyName;

    private double                planetRadius;

    public float                  oxygen;

    public float                  health;

    public float                  temperature;

    private String                selectedWeapon;

    private double                gravity;

    /**
     * @param  guiFocus
     * 
     * @return
     */
    public static String getGUIFocusName(Integer guiFocus)
    {
        String guiFocusName = null;
        if (guiFocus != null)
        {
            guiFocusName = GUI_FOCUS[guiFocus];
        }
        return guiFocusName;
    }

    public boolean isDocked()
    {
        return ((this.flags & FLAG_DOCKED) != 0);
    }

    public boolean isLanded()
    {
        return ((this.flags & FLAG_LANDED) != 0);
    }

    public boolean isLandingGearDown()
    {
        return ((this.flags & FLAG_LANDING_GEAR_DOWN) != 0);
    }

    /**
     * @return
     */
    public boolean areShieldsUp()
    {
        return ((this.flags & FLAG_SHIELDS_UP) != 0);
    }

    public boolean isSupercruise()
    {
        return ((this.flags & FLAG_SUPERCRUISE) != 0);
    }

    public boolean isFlightAssistOff()
    {
        return ((this.flags & FLAG_FLIGHT_ASSIST_OFF) != 0);
    }

    /**
     * @return
     */
    public boolean areHardpointsDeployed()
    {
        return ((this.flags & FLAG_HARDPOINTS_DEPLOYED) != 0);
    }

    public boolean isInWing()
    {
        return ((this.flags & FLAG_IN_WING) != 0);
    }

    /**
     * @return
     */
    public boolean areLightsOn()
    {
        return ((this.flags & FLAG_LIGHTS_ON) != 0);
    }

    public boolean isCargoScoopDeployed()
    {
        return ((this.flags & FLAG_CARGO_SCOOP_DEPLOYED) != 0);
    }

    public boolean isSilentRunning()
    {
        return ((this.flags & FLAG_SILENT_RUNNING) != 0);
    }

    public boolean isScoopingFuel()
    {
        return ((this.flags & FLAG_SCOOPING_FUEL) != 0);
    }

    public boolean isSRVHandbrake()
    {
        return ((this.flags & FLAG_SRV_HANDBRAKE) != 0);
    }

    public boolean isSRVUsingTurretView()
    {
        return ((this.flags & FLAG_SRV_USING_TURRET_VIEW) != 0);
    }

    public boolean isSRVTurretRetracted()
    {
        return ((this.flags & FLAG_SRV_TURRET_RETRACTED) != 0);
    }

    public boolean isSRVDriveAssist()
    {
        return ((this.flags & FLAG_SRV_DRIVE_ASSIST) != 0);
    }

    public boolean isFSDMassLocked()
    {
        return ((this.flags & FLAG_FSD_MASS_LOCKED) != 0);
    }

    public boolean isFSDCharging()
    {
        return ((this.flags & FLAG_FSD_CHARGING) != 0);
    }

    public boolean isFSDCooldown()
    {
        return ((this.flags & FLAG_FSD_COOLDOWN) != 0);
    }

    public boolean isLowFuel()
    {
        return ((this.flags & FLAG_LOW_FUEL) != 0);
    }

    public boolean isOverHeating()
    {
        return ((this.flags & FLAG_OVER_HEATING) != 0);
    }

    /**
     * @return
     */
    public boolean hasLatLong()
    {
        return ((this.flags & FLAG_HAS_LAT_LONG) != 0);
    }

    public boolean isInDanger()
    {
        return ((this.flags & FLAG_IS_IN_DANGER) != 0);
    }

    public boolean isBeingInterdicted()
    {
        return ((this.flags & FLAG_BEING_INTERDICTED) != 0);
    }

    public boolean isInMainShip()
    {
        return ((this.flags & FLAG_IN_MAIN_SHIP) != 0);
    }

    public boolean isInFighter()
    {
        return ((this.flags & FLAG_IN_FIGHTER) != 0);
    }

    public boolean isInSRV()
    {
        return ((this.flags & FLAG_IN_SRV) != 0);
    }

    public boolean isHUDInAnalysisMode()
    {
        return ((this.flags & FLAG_HUD_IN_ANALYSIS_MODE) != 0);
    }

    public boolean isNightVision()
    {
        return ((this.flags & FLAG_NIGHT_VISION) != 0);
    }

    public boolean isAltitudeFromAverageRadius()
    {
        return ((this.flags & FLAG_ALTITUDE_FROM_AVERAGE_RADIUS) != 0);
    }

    public boolean isFSDJump()
    {
        return ((this.flags & FLAG_FSD_JUMP) != 0);
    }

    public boolean isSRVHighBeam()
    {
        return ((this.flags & FLAG_SRV_HIGH_BEAM) != 0);
    }

    public boolean isOnFoot()
    {
        return ((this.flags2 & FLAG2_ON_FOOT) != 0);
    }

    public boolean isInTaxi()
    {
        return ((this.flags2 & FLAG2_IN_TAXI) != 0);
    }

    public boolean isInMulticrew()
    {
        return ((this.flags2 & FLAG2_IN_MULTICREW) != 0);
    }

    public boolean isOnFootInStation()
    {
        return ((this.flags2 & FLAG2_ON_FOOT_IN_STATION) != 0);
    }

    public boolean isOnFootOnPlanet()
    {
        return ((this.flags2 & FLAG2_ON_FOOT_ON_PLANET) != 0);
    }

    public boolean isAimDownSight()
    {
        return ((this.flags2 & FLAG2_AIM_DOWN_SIGHT) != 0);
    }

    public boolean isLowOxygen()
    {
        return ((this.flags2 & FLAG2_LOW_OXYGEN) != 0);
    }

    public boolean isLowHealth()
    {
        return ((this.flags2 & FLAG2_LOW_HEALTH) != 0);
    }

    public boolean isCold()
    {
        return ((this.flags2 & FLAG2_COLD) != 0);
    }

    public boolean isHot()
    {
        return ((this.flags2 & FLAG2_HOT) != 0);
    }

    public boolean isVeryCold()
    {
        return ((this.flags2 & FLAG2_VERY_COLD) != 0);
    }

    public boolean isVeryHot()
    {
        return ((this.flags2 & FLAG2_VERY_HOT) != 0);
    }

    public boolean isGlideMode()
    {
        return ((this.flags2 & FLAG2_GLIDE_MODE) != 0);
    }

    public boolean isOnFootInHangar()
    {
        return ((this.flags2 & FLAG2_ON_FOOT_IN_HANGAR) != 0);
    }

    public boolean isOnFootSocialSpace()
    {
        return ((this.flags2 & FLAG2_ON_FOOT_SOCIAL_SPACE) != 0);
    }

    public boolean isOnFootExterior()
    {
        return ((this.flags2 & FLAG2_ON_FOOT_EXTERIOR) != 0);
    }

    public boolean isBreathableAtmosphere()
    {
        return ((this.flags2 & FLAG2_BREATHABLE_ATMOSPHERE) != 0);
    }
}
