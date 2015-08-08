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
import observer.CurrentAntiPickDisplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DOTA ANTI PICK Application
 */
public class Main extends Application {
    public static final int ROW_COUNT = 7;
    public static final int GAPS_LENGTH = 2;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 930, 930);
        stage.setScene(scene);
        stage.setTitle("Dota antipick");
        stage.setResizable(false);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(GAPS_LENGTH);
        grid.setHgap(GAPS_LENGTH);

        scene.setRoot(grid);

        HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Hero> heroes = heroesBuilder.loadHeroesInfo();

        List<String> heroNames = new ArrayList<String>();

        for (Hero hero : heroes) {
            heroNames.add(hero.getName());
        }

        List<Image> images = heroesBuilder.loadImageHeroes(heroNames);
        System.out.println(images.size());

        Pick pick = new Pick();
        CurrentAntiPickDisplay antiPickDisplay = new CurrentAntiPickDisplay(pick);

        int heroesCount = heroes.size();
        int imageColumn = 0;
        int imageRow = 0;

        for (int i = 0; i < heroesCount; i++) {
            ImageView imageView = new ImageView(images.get(i));

            final int count = i;
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    antiPickDisplay.incrementCurrentCount();
                    Hero hero = heroesBuilder.getHeroByName(heroes, heroes.get(count).getName());
                    pick.addEnemyHeroes(hero, antiPickDisplay.getCurrentCount());
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

    /**
     * showMessageDialog(event, heroes, count);
     */
    private void showMessageDialog(MouseEvent event, List<Hero> heroes, int count) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hero info");
        alert.setContentText("This is " + heroes.get(count).getName());
        alert.showAndWait();
        event.consume();
    }

}