/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Customer.ShoppingCart;
import Business.Role.CustomerRole;
import Business.WorkQueue.OrderRequest;

/**
 *
 * @author ranranhe
 */
public class CustomerAccount extends UserAccount {

    private Customer customer;
    private ShoppingCart cart;

    public CustomerAccount(String username, String password, Customer customer) {
        super(username, password, new CustomerRole());
        this.customer = customer;
        this.cart = new ShoppingCart();
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public ShoppingCart getCart() {
        return this.cart;
    }
}
