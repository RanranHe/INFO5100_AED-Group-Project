/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Restaurant;

import Business.Enterprise.Item;

/**
 *
 * @author ranranhe
 */
public class Dash extends Item {

    private Restaurant restaurant;
//    private String name;
//    private double price;

    public Dash(Restaurant restaurant, String name, double price) {
        super(name, price);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

//    public String getName() {
//        return this.name;
//    }
//    
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return this.price;
//    }
//    
//    public void setPrice(double price) {
//        this.price = price;
//    }
//    
//    @Override
//    public String toString() {
//        return this.name;
//    }
}
