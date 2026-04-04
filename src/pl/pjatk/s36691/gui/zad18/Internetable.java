package pl.pjatk.s36691.gui.zad18;

public interface Internetable {

    default String internet() {
        return "Internet: OK";
    };
}
