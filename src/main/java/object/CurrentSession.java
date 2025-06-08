package object;


public class CurrentSession {

    private static LoggedInUser loggedInUser;

    private CurrentSession() {
        // private constructor to prevent instantiation
    }

    public static void setLoggedInUser(LoggedInUser user) {
        loggedInUser = user;
    }

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public static void clearSession() {
        loggedInUser = null;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public static boolean isOwner() {
        return loggedInUser instanceof Owner;
    }

    public static boolean isManager() {
        return loggedInUser instanceof Manager;
    }

    public static boolean isReceptionist() {
        return loggedInUser instanceof Receptionist;
    }

    public static boolean isAdmin() {
        return loggedInUser instanceof AdminUser;
    }

    public static Owner getAsOwner() {
        return isOwner() ? (Owner) loggedInUser : null;
    }

    public static Manager getAsManager() {
        return isManager() ? (Manager) loggedInUser : null;
    }

    public static Receptionist getAsReceptionist() {
        return isReceptionist() ? (Receptionist) loggedInUser : null;
    }

    public static AdminUser getAsAdmin() {
        return isAdmin() ? (AdminUser) loggedInUser : null;
    }
}
