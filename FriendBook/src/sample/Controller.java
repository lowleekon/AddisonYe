package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public ListView<Friend> friendList = new ListView<Friend>();
    public TextField nameField;
    public TextField ageField;
    public Label nameLabel;
    public Label ageLabel;

    public void getFriend(MouseEvent mouseEvent) {
        Friend temp = friendList.getSelectionModel().getSelectedItem();
        nameLabel.setText(temp.name);
        ageLabel.setText(String.valueOf(temp.age));
    }

    public void addFriend(ActionEvent actionEvent) {
        Friend temp = new Friend(nameField.getText(), Integer.valueOf(ageField.getText()));
        friendList.getItems().add(temp);
        nameField.clear();
        ageField.clear();
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        nameLabel.setText("");
        ageLabel.setText("");
    }
}
