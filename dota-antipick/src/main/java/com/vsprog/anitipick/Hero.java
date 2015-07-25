package com.vsprog.anitipick;

import javafx.scene.image.Image;

/**
 * @author vsa
 */
public class Hero {
    private String name;
    private Image image;

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
}
