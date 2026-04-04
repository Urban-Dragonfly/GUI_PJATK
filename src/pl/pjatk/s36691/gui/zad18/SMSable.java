package pl.pjatk.s36691.gui.zad18;

public interface SMSable {

    default String sms() {
        return "SMS: OK";
    }
}
