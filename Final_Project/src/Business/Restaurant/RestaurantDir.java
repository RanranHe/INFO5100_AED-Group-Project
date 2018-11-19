/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class RestaurantDir {
    private ArrayList<Restaurant> restaurantList;
    
    public RestaurantDir() {
        this.restaurantList = new ArrayList<Restaurant>();
    }
    
    public ArrayList<Restaurant> getRestaurantList() {
        return this.restaurantList;
    }
}
