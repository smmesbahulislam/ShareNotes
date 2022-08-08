
package registerForm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class RegisterController implements Initializable {
    @FXML
    private Button closebtn;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label registrationMessagelbl;
    @FXML
    private Label confirmPasswordlbl;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void registerButtonOnAction(ActionEvent event){
        registerUser();
    }
    
    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
//        Platform.exit();
    }
    
    public void registerUser(){
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            confirmPasswordlbl.setText("");
            registrationMessagelbl.setText("User Has been registered successfully!");
        }
        else{
            confirmPasswordlbl.setText("Password does not match.");
        }
    }
    
    
}
