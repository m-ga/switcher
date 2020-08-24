import java.util.Objects;

import static java.util.Objects.isNull;

public class ComparableSwitcher<T extends Comparable<T>,U> {

    protected T target;
    protected U result;
    protected boolean hasResult;

    ComparableSwitcher(T target, U result) {
        this.target = target;
        this.result = result;
        this.hasResult = true;
    }

    ComparableSwitcher(T target) {
        this.target = target;
        this.hasResult = false;
    }


    public ComparableSwitcher<T,U> val(T when, U result) {
        return val(result, when);
    }

    public ComparableSwitcher<T,U> val(T when, T or, U result) {
        return val(result, when, or);
    }

    public final ComparableSwitcher<T,U> val(U result, T... when){
        if(!hasResult){
            for (T option : when) {
                if(Objects.equals(target, option)){
                    this.result = result;
                    hasResult = true;
                }
            }
        }
        return this;
    }


    public ComparableSwitcher<T,U> in(T from, T to, U result){
        return in(from, to, false, false, result);
    }

    public ComparableSwitcher<T,U> in(T from, T to, boolean exclude, U result){
        return in(from, to, exclude, exclude, result);
    }

    public ComparableSwitcher<T,U> in(T from, T to, boolean excludeFrom, boolean excludeTo, U result){
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


    public U orElse(U defaultValue){
        return hasResult
                ? result
                : defaultValue;
    }


}
