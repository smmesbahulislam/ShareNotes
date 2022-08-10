
package booksAndNotes.notesOfUser;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class NotesOfUserController implements Initializable {
    
    @FXML
    private TableView userTable;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane userPane;
    
    private final ObservableList<user>data = FXCollections.observableArrayList();
    
    @FXML
     private void addYourNotesBtnOnAction(ActionEvent event){
         user user2 = new user("Rohan_2019331021",button[4],UpVote[4],DownVote[4]);
         data.add(user2);
         userTable.setItems(data);
     }
    
    Button []button = new Button[10];
    Button []UpVote = new Button[10];
    Button []DownVote = new Button[10];
    
    private void handleButtonAction(ActionEvent event){
        try{
            if(event.getSource() == button[0])
                System.out.println("hello");
            
        }catch(Exception e){
            
        }
    }
    private void upVoteButtonAction(ActionEvent event){
        try{
            if(event.getSource() == UpVote[0])
                System.out.println("I am Up Vote");
            
        }catch(Exception e){
            
        }
    }
    private void downVoteButtonAction(ActionEvent event){
        try{
            if(event.getSource() == DownVote[0])
                System.out.println("Im Down Vote");
            
        }catch(Exception e){
            
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn userName = new TableColumn("USER NAME");
        TableColumn next = new TableColumn("NEXT");
        TableColumn upVote = new TableColumn("UP VOTE");
        TableColumn downVote = new TableColumn("DOWN VOTE");
        
        for(int i = 0;i < button.length;i++){
            button[i] = new Button();
            button[i].setOnAction(this::handleButtonAction);
        }
        for(int j = 0;j < UpVote.length;j++){
            UpVote[j] = new Button();
            UpVote[j].setOnAction(this::upVoteButtonAction);
        }
        for(int k = 0;k < DownVote.length;k++){
            DownVote[k] = new Button();
            DownVote[k].setOnAction(this::downVoteButtonAction);
        }
        
        
        userTable.getColumns().addAll(userName,next,upVote,downVote);
        userName.prefWidthProperty().bind(userTable.widthProperty().multiply(0.6));
        upVote.prefWidthProperty().bind(userTable.widthProperty().multiply(0.1));
        downVote.prefWidthProperty().bind(userTable.widthProperty().multiply(0.1));
        next.prefWidthProperty().bind(userTable.widthProperty().multiply(0.2));
        
        user user1 = new user("Mesbah_2018331096",button[0],UpVote[0],DownVote[0]);
        user user2 = new user("Shoeb_2019331058",button[1],UpVote[1],DownVote[1]);
        user user3 = new user("Minhaj_2019331001",button[2],UpVote[2],DownVote[2]);
        data.addAll(user1,user2,user3);
        
//        final ObservableList<user> data = FXCollections.observableArrayList(
//                new user("Mesbah_2018331096",button[0],UpVote[0],DownVote[0]),
//                new user("Rohan_2019331021",button[1],UpVote[1],DownVote[1])
//        );
        
        userName.setCellValueFactory(new PropertyValueFactory<user,String>("name"));
        next.setCellValueFactory(new PropertyValueFactory<user,String>("Enter"));
        upVote.setCellValueFactory(new PropertyValueFactory<user,String>("UpVote"));
        downVote.setCellValueFactory(new PropertyValueFactory<user,String>("DownVote"));
        
        userTable.setItems(data);
        
        //Search Bar:
        
        FilteredList<user>filteredData = new FilteredList<>(data,b -> true);
        
        filterField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty())
                    return true;
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(user.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });
        
        SortedList<user>sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(userTable.comparatorProperty());
        userTable.setItems(sortedData);
        
    }    
    
}
