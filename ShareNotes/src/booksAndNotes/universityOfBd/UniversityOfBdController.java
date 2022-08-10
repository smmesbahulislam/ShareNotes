
package booksAndNotes.universityOfBd;

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

public class UniversityOfBdController implements Initializable {
    @FXML
    private TableView universityTable;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane universityPane;
    
    Button []button = new Button[3];
    
    private void handleButtonAction(ActionEvent event){
        try{
            if(event.getSource() == button[0]){
//                System.out.println("Button 1");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/nameOfDepartment/nameOfDepartment.fxml"));
                universityPane.getChildren().setAll(pane);
            }
            else if(event.getSource() == button[1]){
//                System.out.println("Button 2");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/nameOfDepartment/nameOfDepartment.fxml"));
                universityPane.getChildren().setAll(pane);
            }
            else if(event.getSource() == button[2]){
//                System.out.println("Button 3");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/nameOfDepartment/nameOfDepartment.fxml"));
                universityPane.getChildren().setAll(pane);
            }
        }catch(Exception e){
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn nameOfTheUniversity = new TableColumn("UNIVERSITY");
        TableColumn actionBtn = new TableColumn("");
        
        for(int i = 0;i < button.length;i++){
            button[i] = new Button();
            button[i].setOnAction(this::handleButtonAction);
        }
        
        universityTable.getColumns().addAll(nameOfTheUniversity,actionBtn);
        
        nameOfTheUniversity.prefWidthProperty().bind(universityTable.widthProperty().multiply(0.8));
        actionBtn.prefWidthProperty().bind(universityTable.widthProperty().multiply(0.2));
        
        final ObservableList<university>data = FXCollections.observableArrayList(
                new university("Shahjalal University Of Science And Tech(SUST)",button[0]),
                new university("Bangladesh University Of Extraordinary Talent(BUET)",button[1]),
                new university("Dhaka University(DU)",button[2])
        );
        
        //associate data with columns
        nameOfTheUniversity.setCellValueFactory(new PropertyValueFactory<university,String>("name"));
        actionBtn.setCellValueFactory(new PropertyValueFactory<university,String>("button"));
        
        //add data inside table
        universityTable.setItems(data);
        
        //Search Bar:
        
        //Wrap the ObservableList in FilteredList(initially display all data).
        FilteredList<university>filteredData = new FilteredList<>(data,d -> true);
        
        filterField.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(university -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                if(university.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });
        
        SortedList<university>sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(universityTable.comparatorProperty());
        universityTable.setItems(sortedData);
    }    
    
}
