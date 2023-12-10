package elite.dangerous.capi.modal.fc.orders;

public interface Purchase {
    String name();
    int total();
    int outstanding();
    int price();
}