package aq.koptev.ichatclient.models;

public class Client {

    private String login;
    private String password;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
