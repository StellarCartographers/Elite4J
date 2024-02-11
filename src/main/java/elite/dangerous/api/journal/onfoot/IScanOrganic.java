/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.onfoot;

import elite.dangerous.model.scan.ScanType;

public interface IScanOrganic
{
    public ScanType scanType();

    public String genus();

    public String species();

    public long systemAddress();

    public long body();
}
