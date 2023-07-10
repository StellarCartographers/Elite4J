package elite.dangerous.capi.meta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
public class Market {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    private final String outpostType = "fleetcarrier";

    @SerializedName("imported")
    private List<Object> imported;

    @SerializedName("exported")
    private List<Object> exported;

    @SerializedName("services")
    private Services services;

    private final Market.Economies economies = new Economies();

    @SerializedName("prohibited")
    private List<Object> prohibited;

    @SerializedName("commodities")
    private List<Commodity> commodities;

    @Getter
    public static class Economies {
        private Economies._136 _136 = new _136();

        @Getter
        public static class _136 {
            private String name = "Carrier";

            private String proportion = "1";
        }
    }

    @Value
    @Builder
    public static class Commodity {
        @SerializedName("id")
        private String id;

        @SerializedName("categoryname")
        private String categoryname;

        @SerializedName("name")
        private String name;

        @SerializedName("stock")
        private String stock;

        @SerializedName("buyPrice")
        private String buyPrice;

        @SerializedName("sellPrice")
        private String sellPrice;

        @SerializedName("demand")
        private String demand;

        @SerializedName("legality")
        private String legality;

        @SerializedName("meanPrice")
        private String meanPrice;

        @SerializedName("demandBracket")
        private String demandBracket;

        @SerializedName("stockBracket")
        private String stockBracket;

        @SerializedName("locName")
        private String locName;
    }

    @Value
    @Builder
    public static class Services {
        @SerializedName("commodities")
        private State commodities;

        @SerializedName("carrierfuel")
        private State carrierfuel;

        @SerializedName("socialspace")
        private State socialspace;

        @SerializedName("refuel")
        private State refuel;

        @SerializedName("repair")
        private State repair;

        @SerializedName("rearm")
        private State rearm;

        @SerializedName("shipyard")
        private State shipyard;

        @SerializedName("outfitting")
        private State outfitting;

        @SerializedName("blackmarket")
        private State blackmarket;

        @SerializedName("voucherredemption")
        private State voucherredemption;

        @SerializedName("exploration")
        private State exploration;

        @SerializedName("bartender")
        private State bartender;

        @SerializedName("vistagenomics")
        private State vistagenomics;

        @SerializedName("pioneersupplies")
        private State pioneersupplies;

        @SerializedName("carriermanagement")
        private State carriermanagement;

        @SerializedName("stationmenu")
        private State stationmenu;

        @SerializedName("dock")
        private State dock;

        @SerializedName("crewlounge")
        private State crewlounge;

        @SerializedName("engineer")
        private State engineer;

        @SerializedName("contacts")
        private State contacts;

        @SerializedName("livery")
        private State livery;

        public List<String> getServicesByState(State state) {
            List<String> services = new ArrayList<>();
            for (Field f : Services.class.getDeclaredFields()) {
                State s;
                try {
                    s = (State) f.get(this);
                    if (s.equals(state)) {
                        services.add(f.getName());
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {}
            }
            return services;
        }
    }

    public enum State {
        @SerializedName("ok")
        AVAILABLE,
        @SerializedName("unavailable")
        UNAVAILABLE,
        @SerializedName("private")
        PRIVATE
    }
}
