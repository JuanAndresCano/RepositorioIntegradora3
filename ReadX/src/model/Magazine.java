package model;

import java.util.Calendar;

public class Magazine extends Product {
    private MCategory category;
    private double subscribeCost;
    private String broadCastPeriodicity;
    private int activeSubs;

    public Magazine(String id,String name, int numOfPages, MCategory category, double subscribeCost, String broadCastPeriodicity){
        super(id, name, numOfPages);
        this.category = category;
        this.subscribeCost = subscribeCost;
        this.broadCastPeriodicity = broadCastPeriodicity;
        this.activeSubs = 0;
    }

    /**
     * The function returns an object of type MCategory.
     * 
     * @return The method is returning an object of type `MCategory`. The specific object being
     * returned is the one stored in the `category` variable.
     */
    public MCategory getMCategory() {
        return category;
    }

    /**
     * The function returns the subscription cost as a double value.
     * 
     * @return The method `getSubscribeCost()` is returning a `double` value, which is the cost of
     * subscription.
     */
    public double getSubscribeCost() {
        return subscribeCost;
    } 

    /**
     * The function returns the value of the variable "broadCastPeriodicity".
     * 
     * @return The method is returning a String value of the variable `broadCastPeriodicity`.
     */
    public String getBroadCastPeriodicity() {
        return broadCastPeriodicity;
    }

    /**
     * This function sets the broadcast periodicity for a certain object.
     * 
     * @param broadCastPeriodicity a String variable that represents the frequency at which a broadcast
     * is sent. It could be daily, weekly, monthly, etc.
     */
    public void setBroadCastPeriodicity(String broadCastPeriodicity){
        this.broadCastPeriodicity = broadCastPeriodicity;
    }

    /**
     * The function returns the number of active subscriptions.
     * 
     * @return The method is returning an integer value representing the number of active
     * subscriptions.
     */
    public int getActiveSubs() {
        return activeSubs;
    }

    /**
     * This Java function sets the value of the "activeSubs" variable.
     * 
     * @param activeSubs The parameter activeSubs is an integer value representing the number of active
     * subscriptions. The method sets the value of the instance variable activeSubs to the provided
     * parameter value.
     */
    public void setActiveSubs(int activeSubs) {
        this.activeSubs = activeSubs;
    }

    /**
     * This Java function updates the number of active subscriptions by adding the value of new
     * subscriptions to the current number of active subscriptions.
     * 
     * @param newSubs The parameter "newSubs" is an integer value representing the number of new
     * subscribers that need to be added to the existing number of active subscribers.
     */
    public void updateActiveSubs(int newSubs){
        this.activeSubs = getActiveSubs() + newSubs;
    }

    /**
     * This function sets the cost of subscription for a certain object.
     * 
     * @param subscribeCost The parameter `subscribeCost` is a double type variable that represents the
     * cost of subscribing to a service or product. The `setSubscribeCost` method is used to set the
     * value of this variable.
     */
    public void setSubscribeCost(double subscribeCost){
        this.subscribeCost = subscribeCost;
    }

    /**
     * The function increments the number of active subscriptions.
     */
    public void newSub(){
        this.activeSubs++;
    }
    
}
