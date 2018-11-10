/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;

/**
 *
 * @author harshalneelkamal
 */
public class Customer {
        private int customerId;
    private ArrayList<Order> orders;
    
    public Customer(int customerId) {
        this.customerId = customerId;
        this.orders = new ArrayList<>();
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int newId) {
        this.customerId = newId;
    }
    
    public ArrayList<Order> getCustomerOrders() {
        return this.orders;
    }
}
