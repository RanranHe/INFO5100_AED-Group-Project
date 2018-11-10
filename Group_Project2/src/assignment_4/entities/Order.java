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
public class Order {
    int orderId;
    int supplierId;
    int customerId;
    ArrayList<Item> items;

    public Order(int orderId, int supplierId, int customerId) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.customerId = customerId;
        this.items = new ArrayList<Item>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Item> getItem() {
        return items;
    }
}
