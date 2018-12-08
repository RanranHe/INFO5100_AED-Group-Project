package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Enterprise.DeliveryCompany.DeliveryCompany;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Enterprise.Restaurant.Dash;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Enterprise.Store.Product;
import Business.Enterprise.Store.Store;
import Business.Organization.DeliveryManOrganization;
import Business.Role.BossRole;
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
        Employee employee1 = system.getEmployeeDirectory().createEmployee("Ranran", "He", "212212", "ranran@demo.com");
        UserAccount ua1 = system.getUserAccountDirectory().createEmployeeAccount("sysadmin", "sysadmin", new SystemManagerRole(), employee1);

        // Customer, belongs to SYSTEM
        Customer c1 = system.getCustomers().createCustomer("2", "2", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua2 = system.getUserAccountDirectory().createCustomerAccount("2", "2", c1);

        Customer c2 = system.getCustomers().createCustomer("1", "1", "he.ra@husky.neu.edu", "1231231234");
        UserAccount ua3 = system.getUserAccountDirectory().createCustomerAccount("1", "1", c2);

        // MA NETWORK 
        Network network1 = system.createNetwork("Boston");
        Network network2 = system.createNetwork("Atlanta");

        // BOSTON Enterprise with organiztions created
        DeliveryCompany enter1 = network1.createDeliveryCompany("Boston Delivery Company", "1 Pleasant Street, Boston, MA 02125", "(617) 553-5900");
        enter1.setDescription("This is a delivery company.");
        enter1.setId("Delivery");
        enter1.setPath("Images/DeliveryCompanyCut/default.png");
        Employee boss = enter1.getEmployeeDirectory().createEmployee("boss", "boss", "23323", "boss@com");
        UserAccount bossA = enter1.getUserAccountDirectory().createEmployeeAccount("delivery", "delivery", new BossRole(), boss);
        // BOSTON Delivery Company Organization
        ManagerOrganization mo1 = (ManagerOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        DeliveryManOrganization do1 = (DeliveryManOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.DeliveryMan);
        Employee employee2 = mo1.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com");
        UserAccount ua4 = mo1.getUserAccountDirectory().createEmployeeAccount("m", "m", new ManagerRole(), employee2);

        Employee employee3 = mo1.getEmployeeDirectory().createEmployee("Delivery", "Man", "1111", "deliveryman@demo.com");
        UserAccount ua5 = mo1.getUserAccountDirectory().createEmployeeAccount("d", "d", new DeliveryManRole(), employee3);

        Employee employee4 = do1.getEmployeeDirectory().createEmployee("Delivery", "Man", "1111", "deliveryman1@demo.com");
        UserAccount ua8 = do1.getUserAccountDirectory().createEmployeeAccount("dd", "dd", new DeliveryManRole(), employee4);

        // BOSTON Restaurant List
        Restaurant res1 = network1.createRestaurant("Row 34", "383 Congress St, Boston, MA 02210", "(617) 553-5900");
        res1.setCategory(Restaurant.RestaurantCategory.Seafood);
        res1.setId("Row");
        res1.setPath("Images/RestaurantCut/default.png");
        res1.setDescription("This stylish brick-&-wood eatery serves an extensive oyster menu plus fish entrees & craft beers.");
        Dash dash1 = new Dash(res1, "Dash1", 20);
        Dash dash2 = new Dash(res1, "Dash2", 30);
        Dash dash3 = new Dash(res1, "Dash3", 27.6);
        res1.addDashToMenu(dash1);
        res1.addDashToMenu(dash2);
        res1.addDashToMenu(dash3);
        
        Employee b1 = res1.getEmployeeDirectory().createEmployee("Row34", "Boss", "12344", "boss@row34.com");
        UserAccount ba1 = res1.getUserAccountDirectory().createEmployeeAccount("row34", "row34", new BossRole(), b1);
        
        ManagerOrganization mo2 = (ManagerOrganization) res1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        Employee em1 = mo2.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com");
        UserAccount ua6 = mo2.getUserAccountDirectory().createEmployeeAccount("rm", "rm", new ManagerRole(), em1);

        Restaurant res2 = network1.createRestaurant("Legal Harborside", "270 Northern Ave, Boston, MA 02210", "(617) 477-2900");
        res2.setCategory(Restaurant.RestaurantCategory.Seafood);
        res2.setId("legal");
        res2.setPath("Images/RestaurantCut/default.png");
        res2.setDescription("Specializing in upmarket seafood, this contemporary chain also serves steaks & cocktails.");
        Dash d1 = new Dash(res1, "D1", 10);
        Dash d2 = new Dash(res1, "D2", 14);
        Dash d3 = new Dash(res1, "D3", 11.99);
        res2.addDashToMenu(d1);
        res2.addDashToMenu(d2);
        res2.addDashToMenu(d3);
        
        Employee e = res2.getEmployeeDirectory().createEmployee("Legal", "Boss", "222", "boss@demo.com");
        UserAccount ee = res2.getUserAccountDirectory().createEmployeeAccount("legal", "legal", new BossRole(), e);
        
        ManagerOrganization mo3 = (ManagerOrganization) res2.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        Employee em2 = mo3.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount ua7 = mo3.getUserAccountDirectory().createEmployeeAccount("lm", "lm", new ManagerRole(), em2);

        // Boston Store List
        Store store1 = network1.createStore("Whole Foods", "15 Westland Ave, Boston, MA 02115", "(617) 375-1010");
        store1.setId("whole");
        store1.setPath("Images/StoreCut/default.png");
        store1.setCategory(Store.StoreCategory.Organic);
        store1.setDescription("Eco-minded chain with natural & organic grocery items, housewares & other products.");
        Product p1 = new Product(store1, "Cookie", 2);
        Product p2 = new Product(store1, "Coke", 2.5);
        Product p3 = new Product(store1, "Water", 1);
        Product p4 = new Product(store1, "fork", 6);
        store1.addProductToList(p1);
        store1.addProductToList(p2);
        store1.addProductToList(p3);
        store1.addProductToList(p4);
        
        Employee se1 = store1.getEmployeeDirectory().createEmployee("Whole", "Foods", "222", "boss@demo.com");
        UserAccount sa1 = store1.getUserAccountDirectory().createEmployeeAccount("whole", "whole", new BossRole(), e);
        
        ManagerOrganization mo4 = (ManagerOrganization) store1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        Employee se2 = mo4.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount sa2 = mo4.getUserAccountDirectory().createEmployeeAccount("wm", "wm", new ManagerRole(), em2);
        
        
        // Atlanta Restaurant List
        Restaurant res = network2.createRestaurant("Home grown GA Restaurant", "968 Memorial Dr SE, Atlanta, GA 30316", "(404) 222-0455");
        res.setCategory(Restaurant.RestaurantCategory.American);
        res.setId("home");
        res.setPath("Images/RestaurantCut/default.png");
        res.setDescription("Laid-back eatery serving locally sourced breakfast & Southern fare in a retro country-diner setting.");
        Dash da1 = new Dash(res, "D1", 10);
        Dash da2 = new Dash(res, "D2", 14);
        Dash da3 = new Dash(res, "D3", 11.99);
        res.addDashToMenu(da1);
        res.addDashToMenu(da2);
        res.addDashToMenu(da3);
        
        Employee he = res.getEmployeeDirectory().createEmployee("Home Grown", "Boss", "222", "boss@demo.com");
        UserAccount hee = res.getUserAccountDirectory().createEmployeeAccount("home", "home", new BossRole(), he);
        
        ManagerOrganization hmo3 = (ManagerOrganization) res.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        Employee hem2 = hmo3.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount hua7 = hmo3.getUserAccountDirectory().createEmployeeAccount("hm", "hm", new ManagerRole(), hem2);
 
        return system;
    }

}
