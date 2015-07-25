package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * DOTA ANTI PICK Application
 */
public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Image> images = heroesBuilder.loadImageHeroes(heroesBuilder.loadHeroesNames());

        String cssBordering = "-fx-border-color:darkblue ; \n" //#090a0c
                + "-fx-border-insets:3;\n"
                + "-fx-border-radius:7;\n"
                + "-fx-border-width:1.0";
        ImageView lft = new ImageView(images.get(0));

        HBox top = new HBox();
        top.getChildren().add(lft);
        top.setStyle(cssBordering);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("context.fxml"));
        stage.setTitle("DOTA ANTI PICK v.1.0.0");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}

/*
WebDriver driver = new HtmlUnitDriver();
driver.get("http://dota2.ru/heroes/statistic/");
driver.close();
 */

/*
HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Image> images = heroesBuilder.loadImageHeroes(heroesBuilder.loadHeroesNames());

        StackPane stackPane = new StackPane();

        List<ImageView> imageView = new ArrayList<ImageView>();
        for (Image image : images) {
            imageView.add(new ImageView(image));
        }

        stackPane.getChildren().addAll(imageView);


        Scene scene = new Scene(stackPane);


        stage.setScene(scene);
        stage.setResizable(false);
 */