import static java.util.Objects.isNull;

public class ComparableTargetSwitcher<T extends Comparable<T>> extends TargetSwitcher<T> {

    ComparableTargetSwitcher(T target) {
        super(target);
    }

    public <U> ComparableSwitcher<T,U> in(T from, T to, U result){
        return in(from, to, false, false, result);
    }

    public <U> ComparableSwitcher<T,U> in(T from, T to, boolean exclude, U result){
        return in(from, to, exclude, exclude, result);
    }

    public <U> ComparableSwitcher<T,U> in(T from, T to, boolean excludeFrom, boolean excludeTo, U result){
        if(aboveFrom(from, excludeFrom) && belowTo(to, excludeTo))
            return new ComparableSwitcher<>(target,result);
        return new ComparableSwitcher<>(target);
    }

    private boolean belowTo(T to, boolean excludeTo) {
        return isNull(to) || to.compareTo(target) > 0 || (!excludeTo && to.compareTo(target) == 0);
    }

    private boolean aboveFrom(T from, boolean excludeFrom) {
        return isNull(from) || from.compareTo(target) < 0 || (!excludeFrom && from.compareTo(target) == 0);
    }

}
