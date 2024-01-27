package model.log;

public class AuditLog {
    public static void log(String action, String username) {
        System.out.println("Action: " + action + " by model.user.User: " + username);
    }
}