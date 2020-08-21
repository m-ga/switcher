import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class TargetSwitcher<T> {


    protected T target;


    TargetSwitcher(T target) {
        this.target = target;
    }

    public <U> Switcher<T,U> option(T when, U result) {
        return option(result, when);
    }

    public <U> Switcher<T,U> option(T when, T or, U result) {
        return option(result, when, or);
    }

    public <U> Switcher<T,U> option(U result, T... when) {
        if (nonNull(when)){
            for (T option : when) {
                if (Objects.equals(target, option)) {
                    return new Switcher<>(target, result);
                }
            }
        } else {
            if (isNull(target)) {
                return new Switcher<>(null, result);
            }
        }
        return new Switcher<>(target);
    }


}
