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
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        stage.setTitle("Dota antipick");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(2);
        grid.setHgap(5);

        scene.setRoot(grid);

        HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Hero> heroes = heroesBuilder.loadHeroesInfo();

        List<String> heroNames = new ArrayList<String>();

        for (Hero hero : heroes) {
            heroNames.add(hero.getName());
        }

        List<Image> images = heroesBuilder.loadImageHeroes(heroNames);
        System.out.println(images.size());

        for (int i = 0; i < 109; i += 3) {
            for (int j = 0, k = 0; j < 109 && k < images.size(); j += 3, k++) {
                ImageView cloud = new ImageView(images.get(k));
                GridPane.setConstraints(cloud, i, j);
                grid.getChildren().add(cloud);
            }
        }
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
