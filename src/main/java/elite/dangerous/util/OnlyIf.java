package elite.dangerous.util;

import java.util.function.*;

public class OnlyIf
{
    public static Function<Double, Boolean> isGreater(double i)
    {
        return t -> ((BiFunction<Double, Double, Boolean>) (i1, i2) -> i1 > i2).apply(t, i);
    }
    
    public static Function<Double, Boolean> isGreaterOrEqual(double i)
    {
        return t -> ((BiFunction<Double, Double, Boolean>) (i1, i2) -> i1 >= i2).apply(t, i);
    }
    
    public static Function<Double, Boolean> isLess(double i)
    {
        return t -> ((BiFunction<Double, Double, Boolean>) (i1, i2) -> i1 < i2).apply(t, i);
    }
    
    public static Function<Double, Boolean> isLessOrEqual(double i)
    {
        return t -> ((BiFunction<Double, Double, Boolean>) (i1, i2) -> i1 <= i2).apply(t, i);
    }
}
