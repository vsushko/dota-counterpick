package com.vsprog.counterpick;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import observer.CurrentCounterpickDisplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DOTA COUNTERPICK Application
 */
public class Main extends Application {
    public static final int ROW_COUNT = 7;
    public static final int GAPS_LENGTH = 2;
    private CurrentCounterpickDisplay currentCounterpickDisplay;
    private Pick pick;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dota counterpick");
        stage.setResizable(false);

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 930, 930);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Menu menu = new Menu("Actions");

        MenuItem clearItem = new MenuItem("Clear", null);
        clearItem.setMnemonicParsing(true);
        clearItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        clearItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                currentCounterpickDisplay.setCurrentCount(0);
                pick.clearPick();
                currentCounterpickDisplay.setIsAnalyzed(false);
                currentCounterpickDisplay.getFinalOutputInfo().clearOutputInfo();

            }
        });
        menu.getItems().add(clearItem);

        MenuItem rateItem = new MenuItem("Rate", null);
        rateItem.setMnemonicParsing(true);
        rateItem.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN));
        rateItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                currentCounterpickDisplay.setCurrentCount(0);
                pick.clearPick();
                currentCounterpickDisplay.setIsAnalyzed(false);
                currentCounterpickDisplay.getFinalOutputInfo().clearOutputInfo();

            }
        });
        menu.getItems().add(rateItem);

        MenuItem counterItem = new MenuItem("Counter", null);
        counterItem.setMnemonicParsing(true);
        counterItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
        counterItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                currentCounterpickDisplay.setCurrentCount(0);
                pick.clearPick();
                currentCounterpickDisplay.setIsAnalyzed(false);
                currentCounterpickDisplay.getFinalOutputInfo().clearOutputInfo();

            }
        });
        menu.getItems().add(counterItem);

        menuBar.getMenus().add(menu);
        vbox.getChildren().add(menuBar);
        stage.setScene(scene);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(GAPS_LENGTH);
        grid.setHgap(GAPS_LENGTH);

        vbox.getChildren().add(grid);

        final HeroesBuilder heroesBuilder = new HeroesBuilder();
        final List<Hero> heroes = heroesBuilder.loadHeroesInfo();

        List<String> heroNames = new ArrayList<String>();

        for (Hero hero : heroes) {
            heroNames.add(hero.getName());
        }

        List<Image> images = heroesBuilder.loadImageHeroes(heroNames);
        System.out.println(images.size());

        pick = new Pick();
        currentCounterpickDisplay = new CurrentCounterpickDisplay(pick);
        currentCounterpickDisplay.setHeroes(heroes);
        OutputInfo outputInfo = new OutputInfo();

        int heroesCount = heroes.size();
        int imageColumn = 0;
        int imageRow = 0;

        for (int i = 0; i < heroesCount; i++) {
            ImageView imageView = new ImageView(images.get(i));

            final int count = i;
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    currentCounterpickDisplay.incrementCurrentCount();
                    Hero hero = heroesBuilder.getHeroByName(heroes, heroes.get(count).getName());
                    pick.addEnemyHeroes(hero, currentCounterpickDisplay.getCurrentCount());

                    if (currentCounterpickDisplay.isAnalyzed()) {
                        showMessageDialog(currentCounterpickDisplay.getFinalOutputInfo());
                    }
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
     * showMessageDialog();
     */
    private void showMessageDialog(OutputInfo outputInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application info");
        alert.setHeaderText("Counterpick");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(outputInfo.getPickBunch()
                        + "win rate: "
                        + String.valueOf(outputInfo.getPickBunch().getWinRateSum())
                        + "\n\n"
        );

        for (Bunch bunch : outputInfo.getBunches()) {
            stringBuilder.append(bunch + " | win rate sum : " + bunch.getWinRateSum() + "\n");
        }

        stringBuilder.append("***************** RAW BUNCHES *******************************\n");

        for (Bunch bunch : outputInfo.getRawBunches()) {
            stringBuilder.append(bunch + " | win rate sum : " + bunch.getWinRateSum() + "\n");
        }

        stringBuilder.append("***************** ALL ENEMIES *******************************\n");

        for (Bunch bunch : outputInfo.getOneHeroBunches()) {
            stringBuilder.append(bunch + " | win rate sum : " + bunch.getWinRateSum() + "\n");
        }

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        textArea.setText(stringBuilder.toString());
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane outputInfoContent = new GridPane();
        outputInfoContent.setMaxWidth(Double.MAX_VALUE);

        Label label = new Label();
        label.setText("Counterpick with maximum win rate summ:");

        outputInfoContent.add(label, 0, 0);
        outputInfoContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(outputInfoContent);
        alert.getDialogPane().setExpanded(true);

        alert.showAndWait();
    }

}