package elite.dangerous.model.carrier;

public enum Operation
{
    BUYPACK,
    SELLPACK,
    RESTOCKPACK;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
