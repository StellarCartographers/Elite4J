/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

import java.util.List;

public interface ISAAScanComplete
{
    public String bodyName();

    public int bodyID();

    public int probesUsed();

    public int efficiencyTarget();

    public long systemAddress();

    public List<String> descoverers();

    public List<String> mappers();
}
