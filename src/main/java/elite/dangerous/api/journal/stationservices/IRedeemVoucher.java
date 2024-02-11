/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

import java.util.List;

import elite.dangerous.model.FactionBounty;

public interface IRedeemVoucher
{
    public String type();

    public long totalAmount();

    public int brokerPercentage();

    public List<FactionBounty> factions();
}
