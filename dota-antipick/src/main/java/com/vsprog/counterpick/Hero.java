package com.vsprog.counterpick;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsa
 */
public class Hero {
    private String name;
    private Image image;
    private List<String> friends;
    private List<String> enemies;
    private double winrate;

    public Hero() {
    }

    public Hero(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<String> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<String> enemies) {
        this.enemies = enemies;
    }

    public double getWinrate() {
        return winrate;
    }

    public void setWinrate(double winrate) {
        this.winrate = winrate;
    }

    public void addEnemy(String enemyName) {
        if (enemies == null) {
            enemies = new ArrayList<String>();
        }
        enemies.add(enemyName);
    }

    public void addFriend(String friendName) {
        if (friends == null) {
            friends = new ArrayList<String>();
        }
        friends.add(friendName);
    }
}
