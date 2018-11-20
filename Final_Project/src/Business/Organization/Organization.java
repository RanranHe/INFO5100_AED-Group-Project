/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDir;
import Business.Restaurant.RestaurantDir;
import Business.Role.Role;
import Business.UserAccount.UserAccountDir;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public abstract class Organization {

    private int organizationId;
    private String name;
    private City city;
    private WorkQueue workQ;
    private RestaurantDir restaurants;
    private EmployeeDir employees;
    private UserAccountDir userAccounts;
    private static int counter;

    
    public enum City {
        Boston
    }
    
    public enum Type {

        Manager("Manager Organization"),
        DeliveryMan("Delivery Man Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name, City city) {
        counter++;
        this.organizationId = counter;
        this.name = name;
        this.city = city;
        this.workQ = new WorkQueue();
        this.restaurants = new RestaurantDir();
        this.employees = new EmployeeDir();
        this.userAccounts = new UserAccountDir();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return this.city.name();
    }
    
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public EmployeeDir getEmployeeDirectory() {
        return employees;
    }

    public RestaurantDir getRestaurantDirectory() {
        return restaurants;
    }

    public UserAccountDir getUserAccountDirectory() {
        return userAccounts;
    }

    public WorkQueue getWorkQueue() {
        return workQ;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQ = workQueue;
    }
}
