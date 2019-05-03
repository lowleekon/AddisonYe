package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller{
    public ListView<Friend> friendList = new ListView<>();
    public ListView<String> outputLog = new ListView<>();
    public TextField nameField;
    public TextField ageField;
    public Label nameLabel;
    public Label ageLabel;

    public void getFriend(MouseEvent mouseEvent) {
        if (friendList.getItems().size() > 0) {
            Friend temp = friendList.getSelectionModel().getSelectedItem();
            nameLabel.setText(temp.name);
            ageLabel.setText(String.valueOf(temp.age));
        }
    }

    private void clearLog(){
        if (outputLog.getItems().size() > 6) {
            outputLog.getItems().remove(outputLog.getItems().size() - 1);
        }
    }

    public void addFriend(ActionEvent actionEvent){
        try {
            if (nameField.getLength() <= 0 || ageField.getLength() <= 0){
                throw new fullNameNeeded();
            }
            String[] nameCheck = nameField.getText().split(" ");
            if (nameCheck.length != 2) {
                throw new fullNameNeeded(nameCheck);
            }if (Integer.valueOf(ageField.getText()) < 1){
                throw new NumberFormatException();
            }
            Friend temp = new Friend(nameField.getText(), Integer.valueOf(ageField.getText()));
            friendList.getItems().add(temp);
            nameField.clear();
            ageField.clear();
        }catch(fullNameNeeded e){
            outputLog.getItems().add(0, e.toString());
            clearLog();
        }catch(NumberFormatException e){
            outputLog.getItems().add(0, "The age field requires a valid integer greater than 0.");
            clearLog();
        }
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        nameLabel.setText("");
        ageLabel.setText("");
    }

    public void sortLN(ActionEvent actionEvent) {
        friendList.getItems().sort(Friend::compareToName);
    }

    public void sortA(ActionEvent actionEvent) {
        friendList.getItems().sort(Friend::compareToAge);
    }
}
