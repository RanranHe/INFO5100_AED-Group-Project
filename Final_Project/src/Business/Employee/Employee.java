/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author ranranhe
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private static int count = 0;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
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

    public void getFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void getLastName(String lastName) {
        this.lastName = lastName;
    }
            
    public String getFullName() {
        return fullName;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
