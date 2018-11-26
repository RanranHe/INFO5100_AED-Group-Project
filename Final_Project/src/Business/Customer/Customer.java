/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.WorkQueue.OrderRequest;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private static int count = 0;

    public Customer(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.address = "";
        this.email = email;
        this.phone = phone;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
            
    public String getFullName() {
        return fullName;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String addr) {
        this.address = addr;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
