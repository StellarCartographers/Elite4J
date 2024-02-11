/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class SeedConverterComposer<IN, TRANS, OUT> implements SeedConverter<IN, OUT>
{
    private final SeedConverter<IN, TRANS>  first;
    private final SeedConverter<TRANS, OUT> second;

    public SeedConverterComposer(SeedConverter<IN, TRANS> first, SeedConverter<TRANS, OUT> second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public OUT convert(IN seed)
    {
        final TRANS trans = first.convert(seed);
        return second.convert(trans);
    }
}
