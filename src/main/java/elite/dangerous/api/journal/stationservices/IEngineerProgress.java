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

import elite.dangerous.model.engineer.Engineer;

public interface IEngineerProgress
{
    public List<Engineer> engineers();

    public int rank();

    public double rankProgress();
}
