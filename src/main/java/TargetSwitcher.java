import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class TargetSwitcher<T> {


    protected T target;


    TargetSwitcher(T target) {
        this.target = target;
    }

    public <U> Switcher<T,U> val(T when, U result) {
        return val(result, when);
    }

    public <U> Switcher<T,U> val(T when, T or, U result) {
        return val(result, when, or);
    }

    public <U> Switcher<T,U> val(U result, T... when) {
        if (nonNull(when)){
            for (T option : when) {
                if (Objects.equals(target, option)) {
                    return new Switcher<>(target, result);
                }
            }
        }
        return new Switcher<>(target);
    }


}
