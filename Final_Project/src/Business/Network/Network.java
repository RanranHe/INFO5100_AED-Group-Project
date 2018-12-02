/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDir;
import Business.Enterprise.Restaurant.Restaurant;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ranranhe
 */
public class Network {

    private String name;
    private EnterpriseDir enterpriseDir;
    private String city;
    
    public Network(String city) {
        enterpriseDir = new EnterpriseDir();
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDir getEnterpriseDirectory() {
        return enterpriseDir;
    }
     
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public DeliveryCompany createDeliveryCompany(String name) {
        DeliveryCompany enter = new DeliveryCompany(name);
        enter.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(enter);
        return enter;
    }
    
    public Restaurant createRestaurant(String name, String address, String phone) {
        Restaurant res = new Restaurant(name, address, phone);
        res.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(res);
        return res;
    }
    
    public ArrayList<Restaurant> getRestaurantList() {
        ArrayList<Restaurant> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof Restaurant) {
                Restaurant res = (Restaurant) en;
                result.add(res);
            }
        }
        return result;
    }
    
    public ArrayList<DeliveryCompany> getDeliveryCompanyList() {
        ArrayList<DeliveryCompany> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof DeliveryCompany) {
                DeliveryCompany del = (DeliveryCompany) en;
                result.add(del);
            }
        }
        return result;
    }
    
//    public ArrayList<DeliveryCompany> getDeliveryCompanyListByCity(String city) {
//        ArrayList<DeliveryCompany> result = new ArrayList<>();
//        for (DeliveryCompany del : this.getDeliveryCompanyList()) {
//            if (del.getCity().equalsIgnoreCase(city)) {
//                result.add(del);
//            }
//        }
//        return result;
//    }
//    
//    public ArrayList<Restaurant> getRestaurantListByCity(String city) {
//        ArrayList<Restaurant> result = new ArrayList<>();
//        for (Restaurant res : this.getRestaurantList()) {
//            if (res.getCity().equalsIgnoreCase(city)) {
//                result.add(res);
//            }
//        }
//        return result;
//    }
}
