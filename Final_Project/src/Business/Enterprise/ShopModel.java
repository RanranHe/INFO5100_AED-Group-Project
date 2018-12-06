/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public abstract class ShopModel extends Enterprise {

    private String name;
    private String address;
    private String phone;
    private String description;
    private ShopType type;
    private ArrayList<Item> items;

    public enum ShopType {

        Restaurant("Restaurant"),
        Store("Store");

        private String value;

        private ShopType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public ShopModel(String name, String address, String phone) {
        super(name);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.items = new ArrayList<>();
    }
    
    public abstract String getCategoryString();
    
    @Override
    public abstract void createOrganizations();

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

    public void setType(ShopType type) {
        this.type = type;
    }

    public abstract ShopType getType();

    public ArrayList<Item> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    public abstract double getRate();
}
