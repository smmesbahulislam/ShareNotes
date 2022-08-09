package booksAndNotes.semester;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;




public class semesterController implements Initializable {
        
        @FXML
        private TableView semesterTable;
        
        @FXML
         private AnchorPane semesterPane;
        
         @FXML
         private TextField filterField;
         
         @FXML
         private Button previousBtn;
       
        Button[] button = new Button[8]; 
        
        public void previousBtnOnAction(ActionEvent event) throws IOException{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/nameOfDepartment/nameOfDepartment.fxml"));
            semesterPane.getChildren().setAll(pane);
        }
        
        private void handleButtonAction(ActionEvent event) {
            try {
                if (event.getSource() == button[0]) {
                     AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
                     semesterPane.getChildren().setAll(pane);
                } 
                else if (event.getSource() == button[1]) {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/semester/semester.fxml"));
                    semesterPane.getChildren().setAll(pane);
                }
                else if (event.getSource() == button[2]) {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/semester/semester.fxml"));
                    semesterPane.getChildren().setAll(pane);
                }

            } catch (Exception e) {

            }
        }
       
       
        @Override
        public void initialize(URL url, ResourceBundle rb) {
                
                TableColumn semesterColumn = new TableColumn("SEMESTERS");
                TableColumn actionbtn = new TableColumn("BUTTON");
                
                for(int i=0;i<button.length;i++)
                {
                        button[i] = new Button();
                        button[i].setOnAction(this::handleButtonAction);
                }
                
               final ObservableList<semester> data = FXCollections.observableArrayList(
                        new semester("1/1",button[0]),
                        new semester("1/2",button[1]),
                        new semester("2/1",button[2]),
                        new semester("2/2",button[3]),
                        new semester("3/1",button[4]),
                        new semester("3/2",button[5]),
                        new semester("4/1",button[6]),
                        new semester("4/2",button[7])     
                ) ;
                
                semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semesters"));
                actionbtn.setCellValueFactory(new PropertyValueFactory<>("button"));
                
                semesterTable.getColumns().addAll(semesterColumn,actionbtn);        
                semesterTable.setItems(data);
                
                semesterColumn.prefWidthProperty().bind(semesterTable.widthProperty().multiply(0.8));
                actionbtn.prefWidthProperty().bind(semesterTable.widthProperty().multiply(0.2));
//        
        }

}