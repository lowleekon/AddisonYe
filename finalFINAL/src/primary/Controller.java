package primary;

import com.esotericsoftware.kryonet.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.lang.model.type.ArrayType;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public TextField serverIDfield;
    public TextField createServerID;
    public TextField usernameField;
    public TextField enterPasswordField;
    public TextField createPasswordField;
    public TextArea messageField;
    public Button serverSettings;
    public ListView<String> serverList = new ListView<>();
    public ListView<String> outputList = new ListView<>();

    private Client client;
    private String username;
    ArrayList<String> display = new ArrayList<>();
    public ArrayList<String> oput = new ArrayList<>();
    int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            client = new Client();
            ControllerList.add(this);
    }

    private void loadWindow(String location, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setResizable(false);
            stage.setOnCloseRequest(event -> {
                ControllerList.remove(this);
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    void kick(Boolean allowance){
        if (!allowance) {
            System.out.println(ControllerList.controllerList.size());
            client.close();
            JOptionPane.showMessageDialog(null, "ERROR: Incorrect Password.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
    }

    void refreshList(){
        Platform.runLater(()-> {
            if (display.size() > 0) {
                serverList.getItems().clear();
                serverList.getItems().addAll(display);
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                refreshList();
            }
        });
    }

    public void updateOutput() {
        Platform.runLater(() -> {
            try {
                outputList.getItems().clear();
                outputList.getItems().addAll(oput);
            }catch(ConcurrentModificationException ignored){}
        });
    }

    public void pressAddServer(ActionEvent actionEvent) {
        try {
            ClientCode.clientStart(client, Integer.parseInt(serverIDfield.getText()), enterPasswordField.getText());
            serverIDfield.clear();
            enterPasswordField.clear();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR: Server ID is missing.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "ERROR: Server not found.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressSendButton(ActionEvent actionEvent) {
        try {
            if(username.isEmpty()){
                throw new NullPointerException();
            }
            ClientCode.clientChatRequest(client, username + "(#" + id + "): " + messageField.getText());
            messageField.clear();
            usernameField.setText(username);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "ERROR: Please set a username.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressDisconnectButton(ActionEvent actionEvent) {
        ClientCode.clientChatRequest(client, username + "(#" + id + ") has disconnected.");
        client.close();
        display.clear();
        serverList.getItems().clear();
    }

    public void pressServerSettings(ActionEvent actionEvent) {
        loadWindow("../fxml/server.fxml", "server settings");
        updateOutput();
    }

    public void pressStartServer(ActionEvent actionEvent) {
        try {
            ServerCode.serverWork(Integer.parseInt(createServerID.getText()), createPasswordField.getText());
            createServerID.clear();
            createPasswordField.clear();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR: Server ID is missing.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressCloseServer(ActionEvent actionEvent) {
        try {
            Controller controller = ControllerList.controllerList.get(0);
            controller.serverList.getItems().add("Server has closed.");
            controller.display.add("Server has closed.");
            ServerCode.server.stop();
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "ERROR: No server running.", "ERROR OCCURRED", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pressSetUsername(ActionEvent actionEvent) {
        username = usernameField.getText();
    }
}
