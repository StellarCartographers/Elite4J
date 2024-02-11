/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Field;
import java.util.*;

@EliteObject
public class ServiceStates
{
    private State commodities;
    private State carrierfuel;
    private State socialspace;
    private State refuel;
    private State repair;
    private State rearm;
    private State shipyard;
    private State outfitting;
    private State blackmarket;
    private State voucherredemption;
    private State exploration;
    private State bartender;
    private State vistagenomics;
    private State pioneersupplies;
    private State carriermanagement;
    private State stationmenu;
    private State dock;
    private State crewlounge;
    private State engineer;
    private State contacts;
    private State livery;

    @JsonIgnore
    public List<String> getServicesByState(State state)
    {
        List<String> services = new ArrayList<>();
        for (Field f : ServiceStates.class.getDeclaredFields())
        {
            State s;
            try
            {
                s = (State) f.get(this);
                if (s.equals(state))
                {
                    services.add(f.getName());
                }
            } catch (IllegalArgumentException | IllegalAccessException e)
            {
            }
        }
        return services;
    }
}