package model.user;

import lombok.Data;

/**
 * Класс клиента
 */
@Data
public abstract class Client {

    /**
     * имя
     */
    private final String username;
    /**
     * пароль
     */
    private final String password;
}
