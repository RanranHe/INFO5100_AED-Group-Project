package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Restaurant.Dash;
import Business.Restaurant.Restaurant;
import Business.Role.DeliveryManRole;
import Business.Role.ManagerRole;
import Business.Role.SystemManagerRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        // System manager, belongs to SYSTEM
        Employee employee1 = system.getEmployeeDirectory().createEmployee("Ranran", "He");
        UserAccount ua1 = system.getUserAccountDirectory().createEmployeeAccount("sysadmin", "sysadmin", new SystemManagerRole(), employee1);

        // Customer, belongs to SYSTEM
        Customer c1 = system.getCustomers().createCustomer("Ran", "He", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua2 = system.getUserAccountDirectory().createCustomerAccount("ran", "ran", c1);

        Customer c2 = system.getCustomers().createCustomer("1", "1", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua3 = system.getUserAccountDirectory().createCustomerAccount("1", "1", c2);
        
        // MA NETWORK 
        Network network1 = system.createNetwork("MA");
        
        // BOSTON Enterprise with organiztions created
        Enterprise enter1 = network1.createEnterprise("Boston Delivery Company", "Boston");
        
//        // BOSTON Employee Organization
        Employee employee2 = enter1.getEmployeeDirectory().createEmployee("Manager", "Manager");
        ManagerOrganization mo1 = (ManagerOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        UserAccount ua4 = mo1.getUserAccountDirectory().createEmployeeAccount("manager", "manager", new ManagerRole(), employee2);
//        system.getUserAccountDirectory().addAccount(ua4);
//        
        Employee employee3 = enter1.getEmployeeDirectory().createEmployee("Delivery", "Man");
        UserAccount ua5 = mo1.getUserAccountDirectory().createEmployeeAccount("deliveryman", "deliveryman", new DeliveryManRole(), employee3);
//        system.getUserAccountDirectory().addAccount(ua5);
//        
        // BOSTON Restaurant List
        Restaurant res1 = enter1.getRestaurantDirectory().createRestaurant("Row 34", "383 Congress St, Boston, MA 02210", "(617) 553-5900");
        res1.setCategory(Restaurant.Category.Seafood);
        res1.setDescription("This stylish brick-&-wood eatery serves an extensive oyster menu plus fish entrees & craft beers.");
        Dash dash1 = new Dash(res1, "Dash1", 20);
        Dash dash2 = new Dash(res1, "Dash2", 30);
        Dash dash3 = new Dash(res1, "Dash3", 27.6);
        res1.addDashToMenu(dash1);
        res1.addDashToMenu(dash2);
        res1.addDashToMenu(dash3);
        UserAccount ua6 = enter1.getUserAccountDirectory().createRestaurantAccount("row34", "row34", res1);
        
        
//        system.getUserAccountDirectory().addAccount(ua6);
        
        Restaurant res2 = enter1.getRestaurantDirectory().createRestaurant("Legal Harborside", "270 Northern Ave, Boston, MA 02210", "(617) 477-2900");
        res2.setCategory(Restaurant.Category.Seafood);
        res2.setDescription("Specializing in upmarket seafood, this contemporary chain also serves steaks & cocktails.");
        Dash d1 = new Dash(res1, "D1", 10);
        Dash d2 = new Dash(res1, "D2", 14);
        Dash d3 = new Dash(res1, "D3", 11.99);
        res2.addDashToMenu(d1);
        res2.addDashToMenu(d2);
        res2.addDashToMenu(d3);
        UserAccount ua7 = enter1.getUserAccountDirectory().createRestaurantAccount("legal", "legal", res2);
//        system.getUserAccountDirectory().addAccount(ua6);
        
        return system;
    }

}
