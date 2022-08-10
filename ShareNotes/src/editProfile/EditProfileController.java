
package editProfile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import dashboard1.DashboardController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class EditProfileController implements Initializable {
    @FXML
    private TextField nameText;
    @FXML
    private TextField usernameText;
    
    @FXML
    private void saveChangesBtnOnAction(ActionEvent event){
//        DashboardController information = new DashboardController();
        DashboardController.showInformation(nameText.getText(), usernameText.getText());
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
