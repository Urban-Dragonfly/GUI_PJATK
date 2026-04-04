package pl.pjatk.s36691.gui.zad18;

public interface Callable {

    default String call() {
        return "Calling: OK";
    };
}
