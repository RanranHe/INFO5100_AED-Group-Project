/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.DashOrder;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class OrderRequest extends WorkRequest {
    private StatusEnum status;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private ArrayList<DashOrder> dashes;

    public OrderRequest(UserAccount sender, UserAccount receiver, ArrayList<DashOrder> dashes) {
        super(sender, receiver);
        this.dashes =dashes;
    }
    
    public String getDeliveryName() {
        return this.deliveryName;
    }
    
    public void setDeliveryName(String name) {
        this.deliveryName = name;
    }
    
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }
    
    public void setDeliveryAddress(String address) {
        this.deliveryAddress = address;
    }
    
    public String getDeliveryPhone() {
        return this.deliveryPhone;
    }
    
    public void setDeliveryPhone(String phone) {
        this.deliveryPhone = phone;
    }
    
    public ArrayList<DashOrder> getDashes() {
        return this.dashes;
    }
    
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
