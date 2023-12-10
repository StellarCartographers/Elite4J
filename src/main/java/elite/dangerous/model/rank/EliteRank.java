package elite.dangerous.model.rank;

public enum EliteRank
{
    I,
    II,
    III,
    IV,
    V;
    
    @Override
    public String toString()
    {
        return "%s %s".formatted(getClass().getSimpleName(), super.toString());
    }
}
