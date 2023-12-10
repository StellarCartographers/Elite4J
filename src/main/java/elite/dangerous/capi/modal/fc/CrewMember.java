package elite.dangerous.capi.modal.fc;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CrewMember
{
    private String      name;
    private String      gender;
    ServiceAvailability enabled;
    private String      faction;
    private int         salary;
    private int         hiringPrice;
    private String      lastEdit;
}
