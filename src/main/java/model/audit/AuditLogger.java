package model.audit;
//todo 7. Не реализован аудит действий пользователя. Аудит это не лог
public class AuditLogger {
    public static void logLogin(String username) {
        // Запись в журнал: пользователь вошел в систему
        System.out.println("User '" + username + "' logged in.");
    }

    public static void logLogout(String username) {
        // Запись в журнал: пользователь вышел из системы
        System.out.println("User '" + username + "' logged out.");
    }

    public static void logAction(String username, String action) {
        // Запись в журнал: выполнено действие пользователем
        System.out.println("User '" + username + "' performed action: " + action);
    }
}
