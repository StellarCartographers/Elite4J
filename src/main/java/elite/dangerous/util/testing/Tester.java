/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing;

import java.text.ParseException;
import java.time.*;

import elite.dangerous.api.journal.startup.IReputation;
import elite.dangerous.core.Event;
import elite.dangerous.journal.events.fleetcarriers.CarrierJumpRequest;

class Tester
{
    public static void main(String[] args) throws ParseException
    {
        var r = new IReputation()
        {
            @Override
            public double independent()
            {
                return 0.000000;
            }
            
            @Override
            public double federation()
            {
                return 75.000000;
            }
            
            @Override
            public double empire()
            {
                return 75.000000;
            }
            
            @Override
            public double alliance()
            {
                return 75.000000;
            }
        };
        
        System.out.println(r.getAllianceReputationReadable());
        System.out.println(r.getEmpireReputationReadable());
        System.out.println(r.getIndependentReputationReadable());
        System.out.println(r.getFederationReputationReadable());
    }

    static Duration toDuration(CarrierJumpRequest event)
    {
        return Duration.between(event.timestamp().asInstant(), Instant.from(ZonedDateTime.parse(event.departureTime()).withZoneSameInstant(ZoneId.of("UTC"))));
    }

    static <T extends Event> void printInfo(T t)
    {
        print(t.getClass().getSimpleName());
        print(t.toJson());
    }

    static void print(Object obj)
    {
        System.out.println(obj);
    }
}
