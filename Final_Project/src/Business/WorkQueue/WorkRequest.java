/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Date requestDate;
    private Date resolveDate;

    public enum StatusEnum {

        Processing("Processing"),
        PreparingFood("Preparing food"),
        WaitForPickup("Waiting for pickup"),
        OnTheWay("On the way"),
        Cancelled("Cancelled"),
        Completed("Completed");

        private String value;

        private StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public WorkRequest(UserAccount sender, UserAccount receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.requestDate = new Date();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String mess) {
        this.message = mess;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getRequestDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(this.requestDate);
        return dateString;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return this.getRequestDate();
    }
}
