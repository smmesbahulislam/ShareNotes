package myUploads;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MyUploadsController implements Initializable {

        @FXML
        private TableView upTable;

        @FXML
         private AnchorPane upPane;
        
         @FXML
         private TextField filterField;
         
         public int noOfUploads = 3;
         Button[] buttons = new Button[noOfUploads];
         
         private void handleButtonAction(ActionEvent event) {
            try {
                    System.out.println("handling");
                    for(int i=0;i<noOfUploads;i++)
                    {
                       if (event.getSource() == buttons[i]) {
                             AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
                             upPane.getChildren().setAll(pane);
                             break;
                      }
                    }
            } catch (Exception e) {
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                TableColumn fileNameColumn = new TableColumn("File Name");
                TableColumn courseNameColumn = new TableColumn("Course Name");
                TableColumn topicColumn = new TableColumn("Topic");
                 TableColumn buttonColumn = new TableColumn("button");
                
                for(int i=0; i<buttons.length; i++)
                {
                        buttons[i] = new Button();
                        buttons[i].setOnAction(this::handleButtonAction);
                }
                
                final ObservableList<myUploads> data = FXCollections.observableArrayList(
                        new myUploads("Note1","Topic1","Structured Programming Language",buttons[0]),
                        new myUploads("Note2","Topic2","Discrete Mathemetics",buttons[1]),
                        new myUploads("Note2","Topic3","Physics",buttons[2])
                     ) ;
                
                fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
                courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
                topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
                 buttonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
                
                fileNameColumn.prefWidthProperty().bind(upTable.widthProperty().multiply(0.3));
                courseNameColumn.prefWidthProperty().bind(upTable.widthProperty().multiply(0.3));
                topicColumn.prefWidthProperty().bind(upTable.widthProperty().multiply(0.3));
                buttonColumn.prefWidthProperty().bind(upTable.widthProperty().multiply(0.1));
               
                upTable.getColumns().addAll(fileNameColumn,courseNameColumn,topicColumn,buttonColumn);
                upTable.setItems(data);
                
                //search bar
                
                FilteredList<myUploads>filteredData = new FilteredList<>(data,b -> true);
                
               filterField.textProperty().addListener((observable,oldValue,newValue) -> {
               filteredData.setPredicate(myUploads -> {
                //If filter text is empty,display all persons.
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                //Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(myUploads.getFileName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(myUploads.getCourseName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(myUploads.getTopic().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });
        
        //3.Wrap the FilteredList in a SortedList
        SortedList<myUploads>sortedData = new SortedList<>(filteredData);
        
        //4.Bind the SortedList Comparator to the TableView comparator.
        //Otherwise,sorting the TableView would have no effect
        sortedData.comparatorProperty().bind(upTable.comparatorProperty());
        
        //5.add sorted data to the table.
        upTable.setItems(sortedData);
    }    
    
}
