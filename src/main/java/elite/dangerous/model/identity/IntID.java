package elite.dangerous.model.identity;

final class IntID extends ID
{
    public IntID(int id)
    {
        super(Integer.valueOf(id).longValue());
    }
}
