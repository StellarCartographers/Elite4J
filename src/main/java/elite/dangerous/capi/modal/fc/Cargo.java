package elite.dangerous.capi.modal.fc;

import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EliteObject;

@EliteObject
public class Cargo
{
    private String  commodity;
    private String  originSystem;
    private boolean mission;
    @JsonProperty("qty")
    private int     quantity;
    private int     value;
    private boolean stolen;
    private String  locName;

    @JsonIgnore
    public static Predicate<? super Cargo> TritiumPredicate = cargo -> cargo.commodity().equalsIgnoreCase("tritium");
}
