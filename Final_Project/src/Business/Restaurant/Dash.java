/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

/**
 *
 * @author ranranhe
 */
public class Dash {

    private Restaurant restaurant;
    private String name;
    private double price;

    public Dash(Restaurant restaurant, String name, double price) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
