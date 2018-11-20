/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Role.Role;
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
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equalsIgnoreCase(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public boolean isUsernameValid(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(username)){
                return false;
            } 
        }
        return true;    
    }

    public RestaurantAccount createRestaurantAccount(String username, String password, Restaurant rest, Role role) {
        RestaurantAccount ra = new RestaurantAccount(username, password, rest);
        userAccountList.add(ra);
        return ra;
    }

    public EmployeeAccount createEmployeeAccount(String username, String password, Role role, Employee em) {
        EmployeeAccount ua = new EmployeeAccount(username, password, role, em);
        userAccountList.add(ua);
        return ua;
    }
    
    public CustomerAccount createCustomerAccount(String username, String password, Customer customer) {
        CustomerAccount ua = new CustomerAccount(username, password, customer);
        userAccountList.add(ua);
        return ua;
    }
}
