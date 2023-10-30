package elite.dangerous.capi.modal.fleetcarrier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Market
{
    private String                 id;
    private String                 name;
    private final String           outpostType = "fleetcarrier";
    private List<Object>           imported;
    private List<Object>           exported;
    private Services               services;
    private final Market.Economies economies   = new Economies();
    private Object                 prohibited;
    private List<Commodity>        commodities;

    @Getter
    public static final class Economies
    {
        private final Economies._136 _136 = new _136();

        @Getter
        public static final class _136
        {
            private final String name       = "Carrier";
            private final String proportion = "1";
        }
    }

    @Data
    @Builder
    @Jacksonized
    public static class Commodity
    {
        private int    id;
        private String categoryname;
        private String name;
        private int    stock;
        private int    buyPrice;
        private int    sellPrice;
        private int    demand;
        private String legality;
        private int    meanPrice;
        private int    demandBracket;
        private String stockBracket;
        private String locName;
    }

    @Data
    @Builder
    @Jacksonized
    public static class Services
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
            for (Field f : Services.class.getDeclaredFields())
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

    public enum State
    {
        @JsonProperty("ok")
        OK,
        @JsonProperty("unavailable")
        UNAVAILABLE,
        @JsonProperty("private")
        PRIVATE
    }
}
