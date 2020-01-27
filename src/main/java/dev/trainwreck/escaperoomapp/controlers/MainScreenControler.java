package dev.trainwreck.escaperoomapp.controlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Set;


public class MainScreenControler {
    @FXML TextField textfield;
    @FXML ListView textAreaScroll;
    private Set<String> stringSet;
    ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    private void testButton(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            if(!observableList.contains(textfield.getText())){
                observableList.add(0,textfield.getText());
                textAreaScroll.setItems(observableList);
            }
            textfield.setText("");
        }
    }


    @FXML
    private void listSelect(MouseEvent event){
        textfield.setText(textAreaScroll.getSelectionModel().getSelectedItem().toString());
    }

}
