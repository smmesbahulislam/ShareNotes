
package user_login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginController implements Initializable {
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginbtn;
    @FXML
    private Button cancelbtn;
    @FXML
    private Button signupbtn;
    @FXML
    private Label loginMessagelbl;  


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void loginButtonOnAction(ActionEvent event)throws Exception{
        if(usernameField.getText().equals("") && passwordField.getText().equals("")){
            Stage stage = (Stage) loginbtn.getScene().getWindow();
            stage.close();
            dashboard();
        }
            //loginMessagelbl.setText("Login Successfull.");
        else
            loginMessagelbl.setText("Love you!!!!");
    }
    
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelbtn.getScene().getWindow();
        stage.close();
    }
    
    public void signupButtonOnAction(ActionEvent event)throws Exception{
        createAccountForm();
    }
    
    public void createAccountForm() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/registerForm/register.fxml"));
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.DECORATED);
        registerStage.setScene(new Scene(root));
        registerStage.show();
    }
    
    public void dashboard() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard1/dashboard.fxml"));
        Stage dashboard = new Stage();
        dashboard.setTitle("Dashboard");
//        dashboard.initStyle(StageStyle.DECORATED);
        dashboard.setScene(new Scene(root));
        dashboard.show();
    }
    
}
