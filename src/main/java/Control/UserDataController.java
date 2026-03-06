package Control;

import Model.UserModel;

public class UserDataController {
    
    HashingPassword hp = new HashingPassword();
    
    public void hashPassword(UserModel userModel) {
        userModel.setHashPassword(hp.hash(userModel.getPassword()));
    }
    
    public String hashOnly(char[] rawPassword) {
        String hash = hp.hash(rawPassword);
        
        return hash;
    }
    
}
