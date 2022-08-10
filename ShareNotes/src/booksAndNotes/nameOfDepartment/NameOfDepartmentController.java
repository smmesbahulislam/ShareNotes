
package booksAndNotes.nameOfDepartment;

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


public class NameOfDepartmentController implements Initializable {
    @FXML
    private TableView depTable;

    @FXML
    private AnchorPane departmentPane;

    @FXML
    private TextField filterField;
    
    @FXML
    private Button previousBtn;
    
    Button []button = new Button[3];
    
    private void handleButtonAction(ActionEvent event) {
        try {
            for(int i = 0;i < button.length;i++)
            if (event.getSource() == button[i]) {
                System.out.println("Button 1");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/semester/semester.fxml"));
                departmentPane.getChildren().setAll(pane);
            } 
//            else if (event.getSource() == button[1]) {
//                System.out.println("Button 2");
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
//                departmentPane.getChildren().setAll(pane);
//            }
//            else if (event.getSource() == button[2]) {
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
//                departmentPane.getChildren().setAll(pane);
//            }

        } catch (Exception e) {
        
        }
    }
    
    public void previousBtnOnAction(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/universityOfBd/universityOfBd.fxml"));
        departmentPane.getChildren().setAll(pane);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn nameOfTheDepartment = new TableColumn("DEPARTMENT");
        TableColumn actionBtn = new TableColumn("BUTTON");
        
        for(int i = 0;i < button.length;i++){
            button[i] = new Button();
            button[i].setOnAction(this::handleButtonAction);
        }
        
        depTable.getColumns().addAll(nameOfTheDepartment,actionBtn);
        
        nameOfTheDepartment.prefWidthProperty().bind(depTable.widthProperty().multiply(0.8));
        actionBtn.prefWidthProperty().bind(depTable.widthProperty().multiply(0.2));
        
        
        final ObservableList<department> data = FXCollections.observableArrayList(
                new department("Computer Science And Engineering",button[0]),
                new department("EEE",button[1]),
                new department("SWE",button[2])
        );
        
        
        //associate data with columns
        nameOfTheDepartment.setCellValueFactory(new PropertyValueFactory<department,String>("name"));
        actionBtn.setCellValueFactory(new PropertyValueFactory<department,String>("button"));
        
        //add data inside table
        depTable.setItems(data);
        
        
        
        //Search Bar :
        
        //Wrap the ObservableList in FilteredList(initiallly display all data).
        FilteredList<department>filteredData = new FilteredList<>(data,b -> true);
        
        //2.Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(department -> {
                //If filter text is empty,display all persons.
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                //Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(department.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });
        
        //3.Wrap the FilteredList in a SortedList
        SortedList<department>sortedData = new SortedList<>(filteredData);
        
        //4.Bind the SortedList Comparator to the TableView comparator.
        //Otherwise,sorting the TableView would have no effect
        sortedData.comparatorProperty().bind(depTable.comparatorProperty());
        
        //5.add sorted data to the table.
        depTable.setItems(sortedData);
        
        
    }    
    
}
