/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.CustomerAccount;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ranranhe
 */
public class DeliveryRequest extends WorkRequest {
    private OrderRequest order;
    
    public DeliveryRequest(UserAccount sender, UserAccount receiver, OrderRequest order) {
        super(sender, receiver);
        this.order = order;
    }
    
    public CustomerAccount getCustomerAccount() {
        return (CustomerAccount) this.order.getSender();
    }
    
    public OrderRequest getOrder() {
        return this.order;
    }
}
