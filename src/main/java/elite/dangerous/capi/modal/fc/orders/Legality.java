package elite.dangerous.capi.modal.fc.orders;

import java.util.function.Predicate;

@FunctionalInterface
public interface Legality<T>
{
    boolean isIllegal(T t);
    
    default Predicate<T> asPredicate() {
        return t -> isIllegal(t);
    }
}