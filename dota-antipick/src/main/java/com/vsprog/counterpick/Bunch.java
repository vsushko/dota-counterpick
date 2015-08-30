package com.vsprog.counterpick;

/**
 * @author vsa
 * @date 10.08.2015.
 */
public class Bunch {
    private String firstHero;
    private String secondHero;
    private String thirdHero;
    private String fourthHero;
    private String fifthHero;
    private double winRateSum;

    public Bunch() {
    }

    public Bunch(String firstHero, String secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Bunch(String firstHero, String secondHero, String thirdHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.thirdHero = thirdHero;
    }

    public Bunch(String firstHero, String secondHero, String thirdHero, String fourthHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.thirdHero = thirdHero;
        this.fourthHero = fourthHero;
    }

    public Bunch(String firstHero, String secondHero, String thirdHero, String fourthHero, String fifthHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.thirdHero = thirdHero;
        this.fourthHero = fourthHero;
        this.fifthHero = fifthHero;
    }

    public String getFirstHero() {
        return firstHero;
    }

    public void setFirstHero(String firstHero) {
        this.firstHero = firstHero;
    }

    public String getSecondHero() {
        return secondHero;
    }

    public void setSecondHero(String secondHero) {
        this.secondHero = secondHero;
    }

    public String getThirdHero() {
        return thirdHero;
    }

    public void setThirdHero(String thirdHero) {
        this.thirdHero = thirdHero;
    }

    public String getFourthHero() {
        return fourthHero;
    }

    public void setFourthHero(String fourthHero) {
        this.fourthHero = fourthHero;
    }

    public String getFifthHero() {
        return fifthHero;
    }

    public void setFifthHero(String fifthHero) {
        this.fifthHero = fifthHero;
    }

    public double getWinRateSum() {
        return winRateSum;
    }

    public void setWinRateSum(double winRateSum) {
        this.winRateSum = winRateSum;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(firstHero != null ? firstHero + " " : "");
        result.append(secondHero != null ? secondHero + " "  : "");
        result.append(thirdHero != null ? thirdHero + " "  : "");
        result.append(fourthHero != null ? fourthHero + " "  : "");
        result.append(fifthHero != null ? fifthHero + " "  : "");

        return result.toString();
    }
}

