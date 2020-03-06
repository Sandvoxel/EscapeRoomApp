package dev.trainwreck.escaperoomapp.controlers;

import dev.trainwreck.escaperoomapp.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.awt.*;


public class ClueScreenController {
    @FXML TextField textfield;
    @FXML ListView<String> clueList;
    @FXML ImageView clueImage;
    private int GameIndex = 0;
    private ObservableList<String> observableList;

    @FXML
    public void initialize(){
        observableList = Main.gameDataList.get(GameIndex).getClueData();
        clueList.setItems(observableList);
        clueImage.setImage(Main.gameDataList.get(GameIndex).getImage());
    }

    @FXML
    private void testButton(KeyEvent keyEvent){
        if(textfield.getText().isEmpty())return;
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            if(!observableList.contains(textfield.getText())){
                observableList.add(0,textfield.getText());
                clueList.setItems(observableList);
            }else{
                observableList.remove(textfield.getText());
                observableList.add(0,textfield.getText());
                clueList.setItems(observableList);
            }
            clueList.setItems(observableList);
            textfield.setText("");
            Main.gameDataList.get(GameIndex).setClueData(observableList);
        }


    }



    @FXML
    private void listRemove(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.DELETE) && !observableList.isEmpty()){
            observableList.remove(clueList.getSelectionModel().getSelectedItem());
            clueList.setItems(observableList);
            Main.gameDataList.get(GameIndex).setClueData(observableList);
        }
    }
    @FXML
    private void setGame(){
        GameIndex--;
        initialize();
    }
    @FXML
    private void setGameNext(){
        GameIndex++;
        initialize();
    }
    @FXML
    private void listSelect(MouseEvent event){
        if(observableList.isEmpty())return;
        textfield.setText(clueList.getSelectionModel().getSelectedItem());
    }

}
