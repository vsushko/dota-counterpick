

package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/*
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ImageGridCell;
*/

/*

http://java-buddy.blogspot.ru/2014/06/javafx-8-imageview-and-detect-mouseevent.html
http://docs.oracle.com/javafx/2/ui_controls/SeparatorSample.java.html
http://stackoverflow.com/questions/9525072/setonmouseclick-javafx-region-not-called
http://stackoverflow.com/questions/17081467/javafx-clickable-image-map
http://stackoverflow.com/questions/25550518/javafx-how-to-add-an-eventhandler-to-a-imageview-contained-in-a-tilepane-contai

*/
public class GridViewDemo extends Application {

    Label caption = new Label("Weather Forecast");
    Label friday = new Label("Friday");
    Label saturday = new Label("Saturday");
    Label sunday = new Label("Sunday");

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        stage.setTitle("Separator Sample");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(2);
        grid.setHgap(5);

        scene.setRoot(grid);

// scene.getStylesheets().add("separatorsample/controlStyle.css");

        Image cloudImage = new Image(
                getClass().getClassLoader().getResource("images/Abaddon.jpg").toString()
        );
        Image sunImage = new Image(
                getClass().getClassLoader().getResource("images/Abaddon.jpg").toString()
        );

        caption.setFont(Font.font("Verdana", 20));

        GridPane.setConstraints(caption, 0, 0);
        GridPane.setColumnSpan(caption, 8);
        grid.getChildren().add(caption);

        final Separator sepHor = new Separator();
        sepHor.setValignment(VPos.CENTER);
        GridPane.setConstraints(sepHor, 0, 1);
        GridPane.setColumnSpan(sepHor, 7);
        grid.getChildren().add(sepHor);

        friday.setFont(Font.font("Verdana", 18));
        GridPane.setConstraints(friday, 0, 2);
        GridPane.setColumnSpan(friday, 2);
        grid.getChildren().add(friday);

        final Separator sepVert1 = new Separator();
        sepVert1.setOrientation(Orientation.VERTICAL);
        sepVert1.setValignment(VPos.CENTER);
        sepVert1.setPrefHeight(80);
        GridPane.setConstraints(sepVert1, 2, 2);
        GridPane.setRowSpan(sepVert1, 2);
        grid.getChildren().add(sepVert1);

        saturday.setFont(Font.font("Verdana", 18));
        GridPane.setConstraints(saturday, 3, 2);
        GridPane.setColumnSpan(saturday, 2);
        grid.getChildren().add(saturday);

        final Separator sepVert2 = new Separator();
        sepVert2.setOrientation(Orientation.VERTICAL);
        sepVert2.setValignment(VPos.CENTER);
        sepVert2.setPrefHeight(80);
        GridPane.setConstraints(sepVert2, 5, 2);
        GridPane.setRowSpan(sepVert2, 2);
        grid.getChildren().add(sepVert2);

        sunday.setFont(Font.font("Verdana", 18));
        GridPane.setConstraints(sunday, 6, 2);
        GridPane.setColumnSpan(sunday, 2);
        grid.getChildren().add(sunday);

        final ImageView cloud = new ImageView(cloudImage);
        GridPane.setConstraints(cloud, 0, 3);
        grid.getChildren().add(cloud);

        final Label t1 = new Label("16");
        t1.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(t1, 1, 3);
        grid.getChildren().add(t1);

        final ImageView sun1 = new ImageView(sunImage);
        GridPane.setConstraints(sun1, 3, 3);
        grid.getChildren().add(sun1);

        final Label t2 = new Label("18");
        t2.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(t2, 4, 3);
        grid.getChildren().add(t2);

        final ImageView sun2 = new ImageView(sunImage);
        GridPane.setConstraints(sun2, 6, 3);
        grid.getChildren().add(sun2);

        final Label t3 = new Label("20");
        t3.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(t3, 7, 3);
        grid.getChildren().add(t3);

        stage.show();
    /*primaryStage.setTitle("Title");
    Group root = new Group();
    Scene scene = new Scene(root, 600, 330, Color.WHITE);

    GridPane gridpane = new GridPane();
    gridpane.setPadding(new Insets(5));
    gridpane.setHgap(10);
    gridpane.setVgap(10);

    final ImageView imv = new ImageView();
    final Image image2 = new Image(getClass().getClassLoader().getResource("images/Abaddon.jpg").toString());
    imv.setImage(image2);

    final HBox pictureRegion = new HBox();

    pictureRegion.getChildren().add(imv);
    gridpane.add(pictureRegion, 1, 1);
    pictureRegion.setAlignment(Pos.CENTER);
    gridpane.add(pictureRegion, 1, 1);

// gridpane.add(pictureRegion, 2, 1);

    root.getChildren().add(gridpane);
    primaryStage.setScene(scene);
    primaryStage.show();

// StackPane root = new StackPane();/
// root.getChildren().add(getImageGrid());
// Scene scene = new Scene(root, 500, 400);
// primaryStage.setScene(scene);
// primaryStage.show();
}
/
private GridView<?> getImageGrid() {

    final Image image = new Image(GridViewDemo.class.getResource("flowers.png").toExternalForm(), 200, 0, true, true);
    final ObservableList<Image> list = FXCollections.<Image>observableArrayList();

    GridView<Image> colorGrid = new GridView<>(list);

    colorGrid.setCellFactory((GridView<Image> x) -> new ImageGridCell());
    for (int i = 0; i < 5; i++) {
        list.add(image);
    }
    return colorGrid;
}

public class ImageGridCell2 extends GridCell<Image> {

    public ImageGridCell2() {
        getStyleClass().add("image-grid-cell");
    }

    @Override
    protected void updateItem(Image item, boolean empty) {
        super.updateItem(item, empty);

        getChildren().clear();

        if (empty) {
            setGraphic(null);
        } else {
            ImageView imageView = new ImageView();
            imageView.fitHeightProperty().bind(heightProperty());
            imageView.fitWidthProperty().bind(widthProperty());
            imageView.setPreserveRatio(item.isPreserveRatio());
            imageView.setSmooth(item.isSmooth());
            imageView.setImage(item);
            setGraphic(imageView);
        }
    }
}

*/
    }
    public static void main(String[] args) {
        launch(args);
    }
}
