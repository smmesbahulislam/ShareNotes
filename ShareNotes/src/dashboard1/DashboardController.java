package dashboard1;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DashboardController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Circle profilePicture;
    @FXML
    private Button logOut;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Label profileName;
    @FXML
    private Label profileUsername;
   
    public static Label staticProfileName;
    public static Label staticProfileUsername;
    
    @FXML
    private void booksAndNotesBtnOnAction(ActionEvent event){
        System.out.println("You clicked me!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/booksAndNotes/universityOfBd/universityOfBd");
        mainPane.setCenter(view);
                
    }
    
    @FXML
    private void favouriteListBtnOnAction(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/favouriteList/favouriteList");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void myUploadsBtnOnAction(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/myUploads/myUploads");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void editProfileBtnOnAction(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("/editProfile/editProfile");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void logOutBtnOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage)logOut.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/user_login/login.fxml"));
        Stage signIn = new Stage();
        signIn.setTitle("Share Notes");
        signIn.initStyle(StageStyle.DECORATED);
        signIn.setScene(new Scene(root));
        signIn.show();
        
    }
    
    public static void showInformation(String name,String username){
        System.out.println(name);
        System.out.println(username);
        staticProfileName.setText(name);
        staticProfileUsername.setText(username);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staticProfileName = profileName;
        staticProfileUsername = profileUsername;
        
        profilePicture.setStroke(Color.BLACK);
        Image im = new Image("/img/branding.jpeg",false);
        profilePicture.setFill(new ImagePattern(im));
//        profilePicture.setEffect(new DropShadow(+25d,0d,+2d,Color.BLACK));
    }    
    
}
