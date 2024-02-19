/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi;

import lombok.*;

import elite.dangerous.capi.modal.profile.*;

@Getter
@Builder(builderMethodName = "Builder")
public class Profile extends CAPIData
{
    private Commander  commander;
    private LastSystem lastSystem;
}
