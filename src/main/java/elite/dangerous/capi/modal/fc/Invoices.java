/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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