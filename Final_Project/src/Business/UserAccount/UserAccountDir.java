/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class UserAccountDir {
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDir() {
        this.userAccountList = new ArrayList<>();
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return this.userAccountList;
    }
}
