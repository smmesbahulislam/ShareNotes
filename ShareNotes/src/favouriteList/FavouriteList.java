package favouriteList;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class FavouriteList {
        private SimpleStringProperty favNote;
        private Button openButton;
        private Button unfavButton;        


        FavouriteList(String favNote,Button openButton, Button unfavButton)
        {
                this.favNote = new SimpleStringProperty (favNote);
                this.openButton = openButton;
                this.openButton.setText("Enter");
                this.unfavButton = unfavButton;
                this.unfavButton.setText("Unfavourite");
        }
        
        public String getFavNote(){
                return favNote.get();
        }
        public void setFavNote(String favNotes){
            this.favNote.set(favNotes);
        }
        public void setOpenButton(Button openButton){
            this.openButton = openButton;
        }
        public void setUnfavButton(Button unfavButton){
            this.unfavButton = unfavButton;
        }
        public Button getOpenButton(){
                return openButton;
        }
        public Button getUnfavButton(){
                return unfavButton;
        }
        
}