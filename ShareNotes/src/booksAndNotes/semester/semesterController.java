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
                for(int i =0;i<7;i++)
                {          
                        if (event.getSource() == button[i]) {
                                System.out.println("1");
                             AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Courses/courses.fxml"));
                             semesterPane.getChildren().setAll(pane);
                             break;
                        } 
                }
                }catch (Exception e) {
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
                
                        //Search Bar :

                FilteredList<semester>filteredData = new FilteredList<>(data,b -> true);

                filterField.textProperty().addListener((observable,oldValue,newValue) -> {
                filteredData.setPredicate(semester -> {
                
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }

                        String lowerCaseFilter = newValue.toLowerCase();

                        if(semester.getSemesters().toLowerCase().indexOf(lowerCaseFilter) != -1){
                            return true;
                        }
                        else
                            return false;
                    });
                });
        
                SortedList<semester>sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(semesterTable.comparatorProperty());
                semesterTable.setItems(sortedData);

        }

}