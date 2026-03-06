package Model;

public class UserSession {
    
    private static int user_id;

    public static int getId_session() {
        return user_id;
    }

    public static void setId_session(int id) {
        user_id = id;
    }
    
}
