/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Employee.Employee;
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

    public UserAccount authenticateUser(String username, String password) {
        UserAccount account = null;
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(username) && ua.getPassword().equals(password)) {
                account = ua;
            }
        }
        return account;
    }

    public boolean isUsernameValid(String username) {
        if (userAccountList.isEmpty()) {
            return true;
        }
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
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

    public void addAccount(UserAccount account) {
        userAccountList.add(account);
    }

    public ArrayList<EmployeeAccount> toEmployeeAccounts() {
        ArrayList<EmployeeAccount> result = new ArrayList<>();
        for (UserAccount ua : this.userAccountList) {
            EmployeeAccount ea = (EmployeeAccount) ua;
            result.add(ea);
        }
        return result;
    }

    public ArrayList<UserAccount> searchCustomerByOverall(String key) {
        ArrayList<UserAccount> result = new ArrayList<>();
        if (!userAccountList.isEmpty()) {
            for (UserAccount u : this.userAccountList) {
                if (u instanceof CustomerAccount) {
                    CustomerAccount c = (CustomerAccount) u;
                    if (c.getUsername().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getFullName().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getPhone().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getEmail().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public void removeAccount(UserAccount account) {
        if (this.userAccountList.contains(account)) {
            this.userAccountList.remove(account);
        }
    }
}
