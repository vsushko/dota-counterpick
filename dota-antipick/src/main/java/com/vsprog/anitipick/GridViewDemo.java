package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemo extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 930, 930);
        stage.setScene(scene);
        stage.setTitle("Dota antipick");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(2);
        grid.setHgap(2);

        scene.setRoot(grid);

        HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Hero> heroes = heroesBuilder.loadHeroesInfo();

        List<String> heroNames = new ArrayList<String>();

        for (Hero hero : heroes) {
            heroNames.add(hero.getName());
        }

        List<Image> images = heroesBuilder.loadImageHeroes(heroNames);
        System.out.println(images.size());

        int heroesCount = heroes.size();
        int imageColumn = 0;
        int imageRow = 0;

        for (int i = 0; i < heroesCount; i++) {
            ImageView imageView = new ImageView(images.get(i));
            grid.add(imageView, imageColumn, imageRow);
            imageColumn++;

            if (imageColumn > 7) {
                imageColumn = 0;
                imageRow++;
            }
        }

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
