import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ComparableTargetSwitcher<T extends Comparable<T>> {

    protected T target;

    public ComparableTargetSwitcher(T target) {
        this.target = target;
    }


    public <U> ComparableSwitcher<T,U> val(T when, U result) {
        return val(result, when);
    }

    public <U> ComparableSwitcher<T,U> val(T when, T or, U result) {
        return val(result, when, or);
    }

    public <U> ComparableSwitcher<T,U> val(U result, T... when) {
        if (nonNull(when)){
            for (T option : when) {
                if (Objects.equals(target, option)) {
                    return new ComparableSwitcher<>(target, result);
                }
            }
        }
        return new ComparableSwitcher<>(target);
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
