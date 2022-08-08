package booksAndNotes.universityOfBd;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class university {
    private SimpleStringProperty name;
    private Button button;
    
    university(String name,Button button){
        this.name = new SimpleStringProperty(name);
        this.button = button;
        this.button.setText("Enter");
    }
    
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public void setButton(Button button){
        this.button = button;
    }
    public Button getButton(){
        return button;
    }
}
