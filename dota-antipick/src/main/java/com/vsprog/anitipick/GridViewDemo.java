package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/*
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ImageGridCell;
*/
public class GridViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
//        root.getChildren().add(getImageGrid());
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
/*
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

    public static void main(String[] args) {
        launch(args);
    }*/
}
