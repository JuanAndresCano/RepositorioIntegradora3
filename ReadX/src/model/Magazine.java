package model;

import java.util.Calendar;

public class Magazine extends Product {
    private MCategory category;
    private double subscribeCost;
    private String broadCastPeriodicity;
    private int activeSubs;

    public Magazine(String id,String name, int numOfPages, Calendar publicationDate, MCategory category, double subscribeCost, String broadCastPeriodicity){
        super(id, name, numOfPages, publicationDate);
        this.category = category;
        this.subscribeCost = subscribeCost;
        this.broadCastPeriodicity = broadCastPeriodicity;
        this.activeSubs = 0;
    }

    public MCategory getCategory() {
        return category;
    }

    public double getSubscribeCost() {
        return subscribeCost;
    } 

    public String getBroadCastPeriodicity() {
        return broadCastPeriodicity;
    }
    public void setBroadCastPeriodicity(String broadCastPeriodicity){
        this.broadCastPeriodicity = broadCastPeriodicity;
    }

    public int getActiveSubs() {
        return activeSubs;
    }

    public void setActiveSubs(int activeSubs) {
        this.activeSubs = activeSubs;
    }

    public void updateActiveSubs(int newSubs){
        this.activeSubs = getActiveSubs() + newSubs;
    }

    public void setSubscribeCost(double subscribeCost){
        this.subscribeCost = subscribeCost;
    }

    public void newSub(){
        this.activeSubs++;
    }
    
}
