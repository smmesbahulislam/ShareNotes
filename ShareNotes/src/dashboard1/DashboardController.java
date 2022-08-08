package dashboard1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DashboardController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private BorderPane mainPane;
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
