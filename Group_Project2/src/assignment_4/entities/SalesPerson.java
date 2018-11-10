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
public class SalesPerson {
    private int salesId;
    private ArrayList<Order> orders;
    
    public SalesPerson(int salesId) {
        this.salesId = salesId;
        this.orders = new ArrayList<>();
    }
    
    public int getSalesId() {
        return this.salesId;
    }
    
    public void setSalesId(int id) {
        this.salesId = id;
    }
    
    public ArrayList<Order> getSalesOrders() {
        return this.orders;
    }
}
