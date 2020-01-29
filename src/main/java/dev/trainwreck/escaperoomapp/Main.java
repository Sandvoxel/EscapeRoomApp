package dev.trainwreck.escaperoomapp;

import dev.trainwreck.escaperoomapp.data.gameobjects.GameData;
import dev.trainwreck.escaperoomapp.util.FileHelper;
import dev.trainwreck.escaperoomapp.util.Util;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static GameData gameData = new GameData("test-game");

    public static List<GameData> gameDataList = new ArrayList<>();

    private Stage primaryStage;
    private GridPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameDataList.add(gameData);
        gameDataList.add(new GameData("meme-game"));
        gameDataList.add(new GameData("gay-game"));
        gameDataList.add(new GameData("mom-game"));

        FileHelper.CreateGameDataDir(gameDataList);
        this.primaryStage = primaryStage;
        showMainView();
    }

    @Override
    public void stop() throws Exception {
        gameData.saveGame();
    }

    private void showMainView() throws IOException {
        this.primaryStage.setTitle("Escape Room App");
        this.primaryStage.setMinWidth(1280);
        this.primaryStage.setMinHeight(720);
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
