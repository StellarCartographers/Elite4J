package elite.dangerous.capi.modal.fc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EliteObject;

@EliteObject
@JsonPropertyOrder({"crewMember", "invoicesWeekToDate", "status"})
public class Service
{
    private CrewMember     crewMember;
    @JsonProperty("invoicesWeekToDate")
    private List<Invoices> invoices;
    private String         status;

    @JsonIgnore
    boolean available()
    {
        return crewMember.enabled.equals(ServiceAvailability.YES);
    }
    
    @JsonIgnore
    boolean unavailable()
    {
        return crewMember.enabled.equals(ServiceAvailability.NO);
    }
}