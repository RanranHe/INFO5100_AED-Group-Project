/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Restaurant.Dash;

/**
 *
 * @author ranranhe
 */
public class DashOrder {

    private Dash dash;
    private int quantity;
    private double totalPrice;

    public DashOrder(Dash dash, int quantity) {
        this.dash = dash;
        this.quantity = quantity;
        this.totalPrice = dash.getPrice() * quantity;
    }

    public Dash getDash() {
        return this.dash;
    }

    public void setDash(Dash dash) {
        this.dash = dash;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }
    
    public double getTotalPrice() {
        return this.totalPrice;
    }
}
