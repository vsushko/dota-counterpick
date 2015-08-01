package com.vsprog.anitipick;

/**
 * Created by vsa on 30.07.2015.
 */
public class HeroWeight {
    private String heroName;
    private int heroWeight;

    public HeroWeight() {
    }

    public HeroWeight(String heroName, int heroWeight) {
        this.heroName = heroName;
        this.heroWeight = heroWeight;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroWeight() {
        return heroWeight;
    }

    public void setHeroWeight(int heroWeight) {
        this.heroWeight = heroWeight;
    }
}
