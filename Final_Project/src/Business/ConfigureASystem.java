package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Role.SystemManagerRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        Employee employee1 = system.getEmployeeDirectory().createEmployee("Ranran", "He");
        UserAccount ua1 = system.getUserAccountDirectory().createEmployeeAccount("sysadmin", "sysadmin", new SystemManagerRole(), employee1);
        
        Customer c1 = system.getCustomers().createCustomer("Ran", "He", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua2 = system.getUserAccountDirectory().createCustomerAccount("Ran", "ran", c1);
        
        Customer c2 = system.getCustomers().createCustomer("1", "1", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua3 = system.getUserAccountDirectory().createCustomerAccount("1", "1", c2);
        
        return system;
    }
    
}
