import java.util.Objects;

class Switcher<T,U> {


    protected T target;
    protected U result;
    protected boolean hasResult;


    Switcher(T target, U result) {
        this.target = target;
        this.result = result;
        this.hasResult = true;
    }

    Switcher(T target) {
        this.target = target;
        this.hasResult = false;
    }


    public static <T extends Comparable<T>> ComparableTargetSwitcher<T> switcher(T target){
        return new ComparableTargetSwitcher<>(target);
    }

    public static <T> TargetSwitcher<T> switcher(T target){
        return new TargetSwitcher<>(target);
    }

    public Switcher<T,U> option(U result, T... when){
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

    public U byDefault(U defaultValue){
        return hasResult
                ? result
                : defaultValue;
    }


}
