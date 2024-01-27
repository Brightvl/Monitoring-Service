package model.log;

public class AuditLog {
    public static void log(String action, String username) {
        System.out.println("Действие: " + action + " пользователь: " + username);
    }
}