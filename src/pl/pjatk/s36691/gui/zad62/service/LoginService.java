package pl.pjatk.s36691.gui.zad62.service;

public class LoginService {

    public boolean login(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }
}
