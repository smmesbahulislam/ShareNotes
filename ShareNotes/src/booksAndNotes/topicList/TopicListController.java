
package booksAndNotes.topicList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TopicListController implements Initializable {
    @FXML
    private TableView topicTable;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane topicPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
