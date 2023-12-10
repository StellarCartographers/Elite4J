package elite.dangerous.capi.modal.fc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EliteObject;

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