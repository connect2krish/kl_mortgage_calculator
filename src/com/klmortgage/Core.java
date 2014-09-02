package com.klmortgage;

/**
 * Created by Krish Venkat on 8/29/2014.
 */
public class Core {

    public double calculateMortgage(double loan, double numOfYrs, double roi, double pmi){

        if(!isLoanAmtUsable(loan)){
            throw new RuntimeException("Please enter valid loan amount");
        }

        if(!isNumYrsUsable(numOfYrs)){
            throw new RuntimeException("Please enter valid Number of Years");
        }

        if(!isROIUsable(roi)){
            throw new RuntimeException("Please enter valid Rate of Interest");
        }

        if(!isPMIUsable(pmi)){
            pmi=0;
        }

        return getMortgagePerMonthWithPMI(loan, numOfYrs, roi, pmi);

    }

    public double getMortgagePerMonthWithPMI(double loan, double numOfYrs, double _roi, double pmi){
        return getMortgagePerMonth(loan,numOfYrs,_roi) + pmi;
    }

    public long getMortgagePerMonth(double loan, double numOfYrs, double _roi){

        double roi = (_roi/12)/100;

        double months = getMonthsFromYrs(numOfYrs);

        double power = Math.pow((1+roi), months);

        double mortgageVal = (loan * roi *power)/(power - 1);

        return Math.round(mortgageVal);

    }

    private double getMonthsFromYrs(double numOfYrs){

        return numOfYrs * 12;
    }

    public boolean isPMIUsable(double pmi){

        if(pmi>=0)
            return true;

        return false;
    }

    public boolean isLoanAmtUsable(double loan){

        if(loan>0)
            return true;

        return false;
    }

    public boolean isROIUsable(double roi){

        if(roi>0 && roi<=100)
            return true;

        return false;
    }

    public boolean isNumYrsUsable(double numOfYrs){

        if(numOfYrs>0 && numOfYrs <=50)
            return true;

        return false;
    }


}
