/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ReviewRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class Restaurant {

    private int id;
    private String name;
    private String address;
    private String phone;
    private Category category;
    private String description;
    private ArrayList<Dash> menu;
    private ArrayList<OrderRequest> orders;
    private ArrayList<ReviewRequest> reviews;
    private double rate;
    private static int counter = 0;

    public enum Category {

        Seafood
    }

    public Restaurant(String name, String address, String phone) {
        this.id = counter;
        counter++;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.menu = new ArrayList<Dash>();
        this.orders = new ArrayList<OrderRequest>();
        this.reviews = new ArrayList<ReviewRequest>();
        this.rate = -1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String des) {
        this.description = des;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category cat) {
        this.category = cat;
    }

    public ArrayList<Dash> getMenu() {
        return this.menu;
    }
    
    public void addDashToMenu(Dash dash) {
        this.menu.add(dash);
    }

    public ArrayList<OrderRequest> getOrders() {
        return this.orders;
    }

    public ArrayList<ReviewRequest> getReviews() {
        return this.reviews;
    }

    public double getRate() {
        return this.rate;
    }

    public void updateRate() {
        int sum = 0;
        if (reviews.isEmpty()) {
            this.rate = -1;
        } else {
            for (ReviewRequest review : reviews) {
                sum = sum + review.getRate();
            }
            BigDecimal bd = new BigDecimal(sum / reviews.size());
            this.rate = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
