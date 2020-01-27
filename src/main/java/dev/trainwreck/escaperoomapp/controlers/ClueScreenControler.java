package dev.trainwreck.escaperoomapp.controlers;

import dev.trainwreck.escaperoomapp.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.util.Set;


public class ClueScreenControler {
    @FXML TextField textfield;
    @FXML ListView clueList;
    private ObservableList observableList;

    @FXML
    public void initialize(){
        observableList = Main.game.getClueData();
        clueList.setItems(observableList);
    }

    @FXML
    private void testButton(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            if(!observableList.contains(textfield.getText())){
                observableList.add(0,textfield.getText());
                clueList.setItems(observableList);
            }else{
                observableList.remove(observableList.indexOf(textfield.getText()));
                observableList.add(0,textfield.getText());
                clueList.setItems(observableList);
            }
            clueList.setItems(observableList);
            textfield.setText("");
            Main.game.setClueData(observableList);
        }


    }

    @FXML
    private void listRemove(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.DELETE)){
            observableList.remove(observableList.indexOf(clueList.getSelectionModel().getSelectedItem().toString()));
            clueList.setItems(observableList);
            Main.game.setClueData(observableList);
        }
    }

    @FXML
    private void listSelect(MouseEvent event){
        textfield.setText(clueList.getSelectionModel().getSelectedItem().toString());
    }

}
