package model;

import java.util.Calendar;

public class Magazine extends Product {
    private MCategory category;
    private double subscribeCost;
    private int[] broadCastPeriodicity;
    private int activeSubs;

    public Magazine(String id,String name, int numOfPages, Calendar publicationDate, MCategory category, double subscribeCost,
    int pDays, int pMonths, int pYears){
        super(id, name, numOfPages, publicationDate);
        this.category = category;
        this.subscribeCost = subscribeCost;
        this.broadCastPeriodicity = new int [3];
        broadCastPeriodicity[0] = pDays;
        broadCastPeriodicity[1] = pMonths;
        broadCastPeriodicity[2] = pYears;
        this.activeSubs = 0;
    }

    public MCategory getCategory() {
        return category;
    }

    public double getSubscribeCost() {
        return subscribeCost;
    } 

    public int[] getBroadCastPeriodicity() {
        return broadCastPeriodicity;
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
    
}
