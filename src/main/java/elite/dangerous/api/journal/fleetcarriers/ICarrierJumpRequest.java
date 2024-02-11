/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

import com.fasterxml.jackson.databind.node.ObjectNode;

import elite.dangerous.api.NodeBuilder;

public interface ICarrierJumpRequest
{
    public long carrierID();

    public String systemName();

    public String body();

    public long systemAddress();

    public int bodyID();

    public String departureTime();

    public default ObjectNode toObjectNode()
    {
        return NodeBuilder.buildNode(this);
    }
}
