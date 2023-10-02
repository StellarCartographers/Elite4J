package elite.dangerous.capi.modal.fleetcarrier;

import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Cargo
{
    private String  commodity;
    private String  originSystem;
    private boolean mission;
    private int     qty;
    private int     value;
    private boolean stolen;
    private String  locName;

    @JsonIgnore
    public static Predicate<? super Cargo> TritiumPredicate = cargo -> cargo.getCommodity().equalsIgnoreCase("tritium");
}
