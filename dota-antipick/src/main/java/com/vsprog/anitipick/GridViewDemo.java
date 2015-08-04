package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemo extends Application {

    public static final int ROW_COUNT = 7;

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

            final int count = i;
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Dialog message");
                    alert.setContentText("This is " + heroes.get(count).getName());
                    alert.showAndWait();
                    event.consume();
                }
            });

            grid.add(imageView, imageColumn, imageRow);
            imageColumn++;

            if (imageColumn > ROW_COUNT) {
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
