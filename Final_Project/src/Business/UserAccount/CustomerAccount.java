/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Role.CustomerRole;

/**
 *
 * @author ranranhe
 */
public class CustomerAccount extends UserAccount {

    private Customer customer;

    public CustomerAccount(String username, String password, Customer customer) {
        super(username, password, new CustomerRole());
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
