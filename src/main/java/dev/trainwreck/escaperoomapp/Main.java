package dev.trainwreck.escaperoomapp;

import dev.trainwreck.escaperoomapp.util.Util;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Escape Room App");
        showMainView();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Util.resource("screens/MainScreen.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        launch(args);
    }
}
