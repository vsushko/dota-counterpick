package com.vsprog.anitipick;

/**
 * @author vsa
 * Date: 28.07.2015.
 */
public class Pick {
    private Hero firstHero, secondHero, thirdHero, fourthHero, fifthHero;

    public Hero getFirstHero() {
        return firstHero;
    }

    public void setFirstHero(Hero firstHero) {
        this.firstHero = firstHero;
    }

    public Hero getSecondHero() {
        return secondHero;
    }

    public void setSecondHero(Hero secondHero) {
        this.secondHero = secondHero;
    }

    public Hero getThirdHero() {
        return thirdHero;
    }

    public void setThirdHero(Hero thirdHero) {
        this.thirdHero = thirdHero;
    }

    public Hero getFourthHero() {
        return fourthHero;
    }

    public void setFourthHero(Hero fourthHero) {
        this.fourthHero = fourthHero;
    }

    public Hero getFifthHero() {
        return fifthHero;
    }

    public void setFifthHero(Hero fifthHero) {
        this.fifthHero = fifthHero;
    }

    @Override
    public String toString() {
        return firstHero.getName() + " " + secondHero.getName() + " " + thirdHero.getName() + " " + fourthHero.getName() + " " + fifthHero.getName();
    }
}
