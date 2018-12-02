/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Restaurant.Dash;
import Business.Enterprise.Restaurant.Restaurant;
import java.math.BigDecimal;

/**
 *
 * @author ranranhe
 */
public class DashOrder {

    private Dash dash;
    private int quantity;
    private double totalPrice;
    private Restaurant restaurant;

    public DashOrder(Restaurant restaurant, Dash dash, int quantity) {
        this.restaurant = restaurant;
        this.dash = dash;
        this.quantity = quantity;
        BigDecimal bd = new BigDecimal(dash.getPrice() * quantity);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public Dash getDash() {
        return this.dash;
    }

    public void setDash(Dash dash) {
        this.dash = dash;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
        BigDecimal bd = new BigDecimal(dash.getPrice() * q);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return this.dash.getName();
    }
}
