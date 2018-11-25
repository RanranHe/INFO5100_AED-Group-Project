/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.CustomerDir;
import Business.Network.Network;
import Business.Network.Network.State;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemManagerRole;
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

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createNetwork(State state) {
        Network network = new Network(state);
        this.networkList.add(network);
        return network;
    }
    
    public CustomerDir getCustomers() {
        return this.customers;
    }
}
