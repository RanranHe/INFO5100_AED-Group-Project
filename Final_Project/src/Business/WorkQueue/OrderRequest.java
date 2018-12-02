/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.DashOrder;
import Business.Enterprise.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class OrderRequest extends WorkRequest {

    private String id;
    private StatusEnum status;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private double amount;
    private DeliveryCompany company;
    private ArrayList<DashOrder> dashes;

    // generate order number
    public static String genId() {
        String orderId
                = (System.currentTimeMillis() + "").substring(1)
                + (System.nanoTime() + "").substring(7, 10);
        System.out.println(orderId);
        return orderId;
    }

    public OrderRequest(Enterprise enterprise, UserAccount account, ArrayList<DashOrder> dashes) {
        super(enterprise, account);
        this.dashes = dashes;
        this.id = genId();
    }
    
    public String getId() {
        return this.id;
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
    
    public DeliveryCompany getCompany(){
        return this.company;
    }
    
    public void setCompany(DeliveryCompany company) {
        this.company = company;
    }
}
