/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

import elite.dangerous.model.carrier.Operation;

public interface ICarrierShipPack
{
    public long carrierID();

    public Operation operation();

    public String packTheme();

    public int packTier();

    public int cost();
}
