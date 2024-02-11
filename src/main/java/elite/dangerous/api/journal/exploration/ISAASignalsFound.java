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

import elite.dangerous.model.ssa.*;

public interface ISAASignalsFound
{
    public String bodyName();

    public long systemAddress();

    public long bodyID();

    public List<Signal> signals();

    public List<Genus> genuses();

    public default List<String> genusNames()
    {
        return genuses().stream().map(Genus::name).toList();
    }
}
