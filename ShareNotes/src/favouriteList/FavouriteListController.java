package favouriteList;

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
public class FavouriteListController implements Initializable {
        
         @FXML
        private TableView favTable;
        
        @FXML
         private AnchorPane favPane;
        
         @FXML
         private TextField filterField;
         
         @FXML
         private Button previousBtn;
         
         public int noOfFav = 3;
         Button[] openButtons = new Button[noOfFav];
         Button[] unfavButtons = new Button[noOfFav];
         
         
        private void handleButtonAction(ActionEvent event) {
            try {
                    System.out.println("handling");
                    for(int i=0;i<noOfFav;i++)
                    {
                        if (event.getSource() == openButtons[i]) {
                             AnchorPane pane = FXMLLoader.load(getClass().getResource("/booksAndNotes/Screen1.fxml"));
                             favPane.getChildren().setAll(pane);
                             break;
                        } 
                        else if (event.getSource() == unfavButtons[i]) {
                            // Remove That Note
                             break;
                        } 
                    }

            } catch (Exception e) {
            }
        }
        
        @Override
    public void initialize(URL url, ResourceBundle rb) {
                TableColumn favNoteColumn = new TableColumn("Favourite Notes");
                TableColumn openButtonColumn = new TableColumn("Enter");
                TableColumn unfavButtonColumn = new TableColumn("Unfavourite");
                
                for(int i=0; i<openButtons.length; i++)
                {
                        openButtons[i] = new Button();
                        openButtons[i].setOnAction(this::handleButtonAction);
                }
                for(int i=0; i<unfavButtons.length; i++)
                {
                        unfavButtons[i] = new Button();
                        unfavButtons[i].setOnAction(this::handleButtonAction);
                }
                
                final ObservableList<FavouriteList> data = FXCollections.observableArrayList(
                        new FavouriteList("Structured Programming Language",openButtons[0],unfavButtons[0]),
                        new FavouriteList("Discrete Mathemetics",openButtons[1],unfavButtons[1]),
                        new FavouriteList("Physics",openButtons[2],unfavButtons[2])
                     ) ;
                
                favNoteColumn.setCellValueFactory(new PropertyValueFactory<>("favNote"));
                openButtonColumn.setCellValueFactory(new PropertyValueFactory<>("openButton"));
                unfavButtonColumn.setCellValueFactory(new PropertyValueFactory<>("unfavButton"));
                
                favNoteColumn.prefWidthProperty().bind(favTable.widthProperty().multiply(0.6));
                openButtonColumn.prefWidthProperty().bind(favTable.widthProperty().multiply(0.2));
                unfavButtonColumn.prefWidthProperty().bind(favTable.widthProperty().multiply(0.2));
               
                favTable.getColumns().addAll(favNoteColumn,openButtonColumn,unfavButtonColumn);
                favTable.setItems(data);
                
                                //search bar

                FilteredList<FavouriteList>filteredData = new FilteredList<>(data,b -> true);
        
                filterField.textProperty().addListener((observable,oldValue,newValue) -> {
               filteredData.setPredicate(FavouriteList -> {
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return FavouriteList.getFavNote().toLowerCase().contains(lowerCaseFilter);
            });
        });
        
        SortedList<FavouriteList>sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(favTable.comparatorProperty());

        favTable.setItems(sortedData);

    }    
    
}
