package elite.dangerous.journal;

public interface ToLowercase
{
    default String lowercase()
    {
        return toString().toLowerCase();
    }
}
