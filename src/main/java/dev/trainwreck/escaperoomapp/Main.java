package dev.trainwreck.escaperoomapp;

import dev.trainwreck.escaperoomapp.data.gameobjects.GameData;
import dev.trainwreck.escaperoomapp.util.Util;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Main extends Application {

    public static GameData gameData = new GameData("Test Game");

    private Stage primaryStage;
    private GridPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Escape Room App");
        this.primaryStage.setMinWidth(1280);
        this.primaryStage.setMinHeight(720);
        showMainView();
    }

    @Override
    public void stop() {
        gameData.saveGame();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Util.resource("screens/ClueScreen.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        initEnvironmentSetup();
        launch(args);
    }

    private static void initEnvironmentSetup(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
