/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package booksAndNotes.Courses;

import java.io.IOException;
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


public class coursesController implements Initializable {

        @FXML
        private TableView courseTable;
        
        @FXML
         private AnchorPane coursePane;
        
         @FXML
         private TextField filterField;
         
         @FXML
         private Button previousBtn;
         
        private int noOfCourses = 3;
        Button[] courseButtons = new Button[3];
        
        public void previousBtnOnAction(ActionEvent event) throws IOException{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/semester/semester.fxml"));
            coursePane.getChildren().setAll(pane);
        }
        
        private void handleButtonAction(ActionEvent event) {
            try {
                    System.out.println("handling");
                if (event.getSource() == courseButtons[0]) {
                     AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/notesOfUser/notesOfUser.fxml"));
                     coursePane.getChildren().setAll(pane);
                } 
                
                else if (event.getSource() == courseButtons[1]) {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
                    coursePane.getChildren().setAll(pane);
                }
                else if (event.getSource() == courseButtons[2]) {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
                    coursePane.getChildren().setAll(pane);
                }

            } catch (Exception e) {
            }
        }
        
        @Override
        public void initialize(URL url, ResourceBundle rb) {
                TableColumn courseTitle = new TableColumn("Course Title");
                TableColumn courseCode = new TableColumn("Course Code");
                TableColumn credit = new TableColumn("Credit");
                TableColumn buttonColumn = new TableColumn("Button");
                
                for(int i=0; i<courseButtons.length; i++)
                {
                        courseButtons[i] = new Button();
                        courseButtons[i].setOnAction(this::handleButtonAction);
                }
                
                final ObservableList<courses> data = FXCollections.observableArrayList(
                        new courses("Structured Programming Language","CSE133","3",courseButtons[0]),
                        new courses("2nd course","CSE123","3",courseButtons[1]),
                        new courses("3rd course","CSE143","3",courseButtons[2])
                     ) ;
                
                courseTitle.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
                courseCode.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
                credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
                buttonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
                
                courseTitle.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.5));
                courseCode.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.15));
                credit.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.15));
                buttonColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.2));

                courseTable.getColumns().addAll(courseTitle,courseCode,credit,buttonColumn);
                courseTable.setItems(data);
                
                //search bar

                FilteredList<courses>filteredData = new FilteredList<>(data,b -> true);
        
                filterField.textProperty().addListener((observable,oldValue,newValue) -> {
               filteredData.setPredicate(courses -> {
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(courses.getCourseTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(courses.getCourseCode().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else  if(courses.getCredit().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });
        
        SortedList<courses>sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(courseTable.comparatorProperty());

        courseTable.setItems(sortedData);

        }        
        
}
