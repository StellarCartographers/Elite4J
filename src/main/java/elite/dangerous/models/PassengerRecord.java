/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models;

import com.google.gson.annotations.SerializedName;

/**
 * The Class PassengerRecord.
 */
public class PassengerRecord
{
    /**
     * The type.
     */
    public String  type;
    /**
     * The count.
     */
    public Integer count;
    /**
     * The vip.
     */
    @SerializedName("VIP")
    public Boolean vip;
    /**
     * The wanted.
     */
    public Boolean wanted;
    /**
     * The mission ID.
     */
    public Long    missionID;
}
