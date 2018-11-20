/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Restaurant.Restaurant;
import Business.Role.RestaurantRole;

/**
 *
 * @author ranranhe
 */
public class RestaurantAccount extends UserAccount {
    private Restaurant rest;
    
    public RestaurantAccount(String username, String password, Restaurant rest) {
        super(username, password, new RestaurantRole());
        this.rest = rest;
    }
    
    public Restaurant getRestaurant() {
        return this.rest;
    }
    
    public void setRestaurant(Restaurant rest) {
        this.rest = rest;
    }
}
