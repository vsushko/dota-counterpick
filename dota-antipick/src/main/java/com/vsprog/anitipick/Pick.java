package com.vsprog.anitipick;

import observer.Observable;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsa
 * Date: 28.07.2015.
 */
public class Pick implements Observable {
    private List<Observer> observers;
    private List<Hero> enemies;
    private Hero firstHero, secondHero, thirdHero, fourthHero, fifthHero;
    private Hero firstEnemy, secondEnemy, thirdEnemy, fourthEnemy, fifthEnemy;

    public Pick() {
        observers = new ArrayList<>();
        enemies = new ArrayList<Hero>();
    }

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
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(firstEnemy, secondEnemy, thirdEnemy, fourthEnemy, fifthEnemy);
        }
    }

    public void addEnemyHeroes(Hero hero, int heroCount) {
        switch (heroCount) {
            case 1:
                this.firstEnemy = hero;
                break;
            case 2:
                this.secondEnemy = hero;
                break;
            case 3:
                this.thirdEnemy = hero;
                break;
            case 4:
                this.fourthEnemy = hero;
                break;
            case 5:
                this.fifthEnemy = hero;
                break;
            default:
                break;
        }

        notifyObservers();
    }

}
