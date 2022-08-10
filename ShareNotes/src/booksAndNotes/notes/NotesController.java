
package booksAndNotes.notes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class NotesController implements Initializable {
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private ListView listView;
    @FXML
    private AnchorPane notesPane;
    
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files","*.pdf"));
        File selectedFile = fc.showOpenDialog(null);
        
        if(selectedFile != null){
            listView.getItems().add(selectedFile.getName());
        }else{
            System.out.println("File is not valid");
        }
    }
    public void Button2Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files","*.pdf"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);
        
        if(selectedFiles != null){
            for(int i = 0;i < selectedFiles.size();i++){
                listView.getItems().add(selectedFiles.get(i).getName());
            }
        }else{
            System.out.println("File is not valid");
        }
        
    }
    
        public void previousBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/notesOfUser/notesOfUser.fxml"));
        notesPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
