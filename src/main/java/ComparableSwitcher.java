import static java.util.Objects.isNull;

public class ComparableSwitcher<T extends Comparable<T>,U> extends Switcher<T,U> {


    ComparableSwitcher(T target, U result) {
        super(target, result);
    }

    ComparableSwitcher(T target) {
        super(target);
    }

    public ComparableSwitcher<T,U> range(T from, T to, U result){
        return range(from, to, false, false, result);
    }

    public ComparableSwitcher<T,U> range(T from, T to, boolean exclude, U result){
        return range(from, to, exclude, exclude, result);
    }

    public ComparableSwitcher<T,U> range(T from, T to, boolean excludeFrom, boolean excludeTo, U result){
        if (!hasResult && aboveFrom(from, excludeFrom) && belowTo(to, excludeTo)){
            this.result = result;
            this.hasResult = true;
        }
        return this;
    }

    private boolean belowTo(T to, boolean excludeTo) {
        return isNull(to) || to.compareTo(target) > 0 || (!excludeTo && to.compareTo(target) == 0);
    }

    private boolean aboveFrom(T from, boolean excludeFrom) {
        return isNull(from) || from.compareTo(target) < 0 || (!excludeFrom && from.compareTo(target) == 0);
    }


}
