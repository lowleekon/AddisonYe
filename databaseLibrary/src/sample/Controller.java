package sample;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField IDFIELD;
    public TextField NAMEFIELD;
    public TextField BORROWERFIELD;
    public ListView<Book> list;

    private boolean sortID = true;
    private boolean sortName = false;

    private DatabaseHandler handler = new DatabaseHandler();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshList();
    }

    private void refreshList(){
        try {
            list.getItems().clear();
            list.getItems().addAll(handler.getItems());
            if (sortID){
                list.getItems().sort(new compareID());
            }
            if (sortName){
                list.getItems().sort(new compareName());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void pressAddButton(ActionEvent actionEvent) {
        try {
            if (IDFIELD.getText().isEmpty() || NAMEFIELD.getText().isEmpty() || BORROWERFIELD.getText().isEmpty()){
                throw new IllegalArgumentException();
            }
            System.out.println(IDFIELD.getText() +  NAMEFIELD.getText() + BORROWERFIELD.getText());
            handler.add(IDFIELD.getText(), NAMEFIELD.getText(), BORROWERFIELD.getText());
            refreshList();
            IDFIELD.clear();
            NAMEFIELD.clear();
            BORROWERFIELD.clear();
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "ERROR: 1 or more fields are missing.", "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressRemoveButton(ActionEvent actionEvent) {
        try {
            Book temp = list.getSelectionModel().getSelectedItem();
            handler.remove(temp.id);
            refreshList();
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "ERROR: Please select an entry from the list below.", "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressSortID(ActionEvent actionEvent) {
        if (sortName){ sortName = false; }
        sortID = true;
        refreshList();
    }

    public void pressSortBorrower(ActionEvent actionEvent) {
        if (sortID){ sortID = false; }
        sortName = true;
        refreshList();
    }
}