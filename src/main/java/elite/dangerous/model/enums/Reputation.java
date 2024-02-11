package elite.dangerous.model.enums;

import java.util.function.Function;

import space.tscg.misc.*;

public enum Reputation
{
    HOSTILE(Numbers.le(-90)),
    UNFRIENDLY(Numbers.le(-35), Numbers.gt(-90)),
    CORDINAL(Numbers.ge(4), Numbers.lt(35)),
    FRIENDLY(Numbers.ge(35), Numbers.lt(90)),
    ALLIED(Numbers.ge(90)),
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
        return StringUtil.capitalize(super.toString());
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
        for(Reputation rep : Reputation.values())
        {
            if(rep.check(reputation))
                return rep;
        }
        return NEUTRAL;
    }
}
