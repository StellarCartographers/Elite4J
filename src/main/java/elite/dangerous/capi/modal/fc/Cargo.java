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

import com.fasterxml.jackson.annotation.*;

import java.util.function.Predicate;

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
