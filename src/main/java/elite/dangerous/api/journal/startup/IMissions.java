/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import java.util.List;

import elite.dangerous.model.Mission;

public interface IMissions
{
    public List<Mission> active();

    public List<Mission> failed();

    public List<Mission> complete();
}
