
package booksAndNotes.notesOfUser;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;


public class user {
    private SimpleStringProperty name;
    private Button enter;
    private Button upVote;
    private Button downVote;
    
    user(String name,Button enter,Button upVote,Button downVote){
        this.name = new SimpleStringProperty(name);
        
        this.enter = enter;
        this.enter.setText("Enter");
        
        this.upVote = upVote;
        this.upVote.setText("Up Vote");
        
        this.downVote = downVote;
        this.downVote.setText("Down Vote");
        
    }
    
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    
    public Button getEnter(){
        return enter;
    }
    public void setEnter(Button enter){
        this.enter = enter;
    }
    public Button getUpVote(){
        return upVote;
    }
    public void setUpVote(Button upVote){
        this.upVote = upVote;
    }
    public Button getDownVote(){
        return downVote;
    }
    public void setDownVote(Button downVote){
        this.downVote = downVote;
    }

}
