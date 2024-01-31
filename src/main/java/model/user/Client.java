package model.user;

import lombok.Data;
import lombok.Getter;

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
