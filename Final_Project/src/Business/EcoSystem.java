/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.CustomerDir;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemManagerRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private CustomerDir customers;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemManagerRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        customers = new CustomerDir();
    }
    
    public boolean isCityAvabliable(String city) {
        for (Network net : this.networkList) {
            if (net.getCity().equalsIgnoreCase(city)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public Network createNetwork(String state) {
        Network network = new Network(state);
        this.networkList.add(network);
        return network;
    }

    public Network getNetworkByCity(String city) {
        for (Network net : this.networkList) {
            if (net.getCity().equals(city)) {
                return net;
            }
        }
        return null;
    }

    public CustomerDir getCustomers() {
        return this.customers;
    }
    
    public UserAccount getCustomerAccountByUsername(String username) {
        for(UserAccount account:this.getUserAccountDirectory().getUserAccountList()) {
            if(account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }
    
    public Enterprise getEnterpriseById(String id) {
        for (Network net : this.networkList) {
            for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                if(en.getId().equals(id)) {
                    return en;
                }
            }
        }
        return null;
    }

    public boolean isUserNameAvaliable(String username) {
        if (this.getUserAccountDirectory().isUsernameValid(username)) {
            for (Network net : this.networkList) {
                for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (en.getUserAccountDirectory().isUsernameValid(username)) {
                        for (Organization or : en.getOrganizationDirectory().getOrganizationList()) {
                            if (!or.getUserAccountDirectory().isUsernameValid(username)) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    public void removeNetwork(Network net) {
        Network result = null;
        if (!this.networkList.isEmpty()) {
            for (Network n : networkList) {
                if (net.getId().equalsIgnoreCase(n.getId())) {
                    result = n;
                }
            }
            networkList.remove(result);
        }
    }
}
