package model.user;

public abstract class Client {

    /**
     * имя
     */
    private String username;
    /**
     * пароль
     */
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //region Getters/setters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    //endregion
}
