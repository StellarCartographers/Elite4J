/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class LoadGame.
 */
@SuperBuilder
@Jacksonized
public class LoadGame extends Event 
{

    /**
     * The commander.
     */
    public String  commander;
    /**
     * The fid.
     */
    @SerializedName("FID")
    public String  fid;
    /**
     * The ship.
     */
    public String  ship;
    /**
     * The ship localised.
     */
    public String  shipLocalised;
    /**
     * The ship name.
     */
    public String  shipName;
    /**
     * The ship ident.
     */
    public String  shipIdent;
    /**
     * The game mode.
     */
    public String  gameMode;
    /**
     * The group.
     */
    public String  group;
    /**
     * The ship ID.
     */
    public Integer shipID;
    /**
     * The fuel level.
     */
    public Double  fuelLevel;
    /**
     * The fuel capacity.
     */
    public Double  fuelCapacity;
    /**
     * The credits.
     */
    public Long    credits;
    /**
     * The loan.
     */
    public Long    loan;
    /**
     * The horizons.
     */
    public Boolean horizons;
    /**
     * The start landed.
     */
    public Boolean startLanded;
    /**
     * The start dead.
     */
    public Boolean startDead;
}
