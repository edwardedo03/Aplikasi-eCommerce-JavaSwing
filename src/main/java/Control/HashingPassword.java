package Control;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashingPassword {
    
    public String hash(char[] password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = new String(password).getBytes(StandardCharsets.UTF_8);
            byte[] hash = md.digest(bytes);
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));        
            }
            
            return sb.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
