package elite.dangerous.journal.models.carrier;

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
