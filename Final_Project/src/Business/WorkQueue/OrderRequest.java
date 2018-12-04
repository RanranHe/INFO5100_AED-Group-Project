/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.ItemOrder;
import Business.Enterprise.DeliveryCompany.DeliveryCompany;
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
    private ArrayList<ItemOrder> dashes;
    private ReviewRequest review;

    // generate order number
    public static String genId() {
        String orderId
                = (System.currentTimeMillis() + "").substring(1)
                + (System.nanoTime() + "").substring(7, 10);
        return orderId;
    }

    public OrderRequest(Enterprise enterprise, UserAccount account, ArrayList<ItemOrder> dashes) {
        super(enterprise, account);
        this.dashes = dashes;
        this.id = genId();
        this.review = null;
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

    public ArrayList<ItemOrder> getItems() {
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

    public DeliveryCompany getCompany() {
        return this.company;
    }

    public void setCompany(DeliveryCompany company) {
        this.company = company;
    }
    
    public boolean isReviewed() {
        if (this.review == null) {
            return false;
        } else {
            if (this.review.getRate() == -1) {
                return false;
            }
        }
        return true;
    }
    
    public void setReview(ReviewRequest review) {
        this.review = review;
    }
    
    public ReviewRequest getReview() {
        return this.review;
    }
    
    public boolean eligableToBeReviewed() {
        if (this.review != null) {
            if (this.review.getRate() == -1) {
                return true;
            }
        }
        return false;
    }
}
