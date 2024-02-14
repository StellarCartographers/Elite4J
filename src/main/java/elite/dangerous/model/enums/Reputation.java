package elite.dangerous.model.enums;

import static elite.dangerous.util.OnlyIf.*;

import java.util.function.Function;

public enum Reputation
{
    HOSTILE(isLessOrEqual(-90)),
    UNFRIENDLY(isLessOrEqual(-35), isGreater(-90)),
    CORDINAL(isGreaterOrEqual(4), isLess(35)),
    FRIENDLY(isGreaterOrEqual(35), isLess(90)),
    ALLIED(isGreaterOrEqual(90)),
    NEUTRAL;

    private Function<Double, Boolean> f1;
    private Function<Double, Boolean> f2;
    private boolean                   hasRange;
    private boolean                   isDefault;

    private Reputation(Function<Double, Boolean> above, Function<Double, Boolean> below)
    {
        this(above);
        this.f2 = below;
        this.hasRange = true;
    }

    private Reputation(Function<Double, Boolean> above)
    {
        this.f1 = above;
    }

    private Reputation()
    {
        this.isDefault = true;
    }

    public boolean check(double i)
    {
        if (isDefault)
        {
            return false;
        } else
        {
            if (hasRange)
            {
                return f1.apply(i) && f2.apply(i);
            } else
            {
                return f1.apply(i);
            }
        }
    }

    @Override
    public String toString()
    {
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }

    /**
     * Gets the readable name.
     *
     * @param  reputation
     *                        the reputation
     * 
     * @return            the readable name
     */
    public static Reputation getReadableName(double reputation)
    {
        for (Reputation rep : Reputation.values())
        {
            if (rep.check(reputation))
                return rep;
        }
        return NEUTRAL;
    }
}
