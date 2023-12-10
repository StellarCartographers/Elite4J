package elite.dangerous.capi.modal.fc;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Invoices
{
    private int    wages;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   from;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   until;
    private String type;
}