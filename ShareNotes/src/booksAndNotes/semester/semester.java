package booksAndNotes.semester;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class semester {
        private SimpleStringProperty semesters;
        private Button button;
        
        semester(String semesters,Button button){
                this.semesters = new SimpleStringProperty(semesters);
                this.button = button;
                this.button.setText("Enter");
        }
        public String getSemesters(){
                return semesters.get();
        }
        
        public void setSemesters(String semesters){
            this.semesters.set(semesters);
        }

        public void setButton(Button button){
            this.button = button;
        }
        public Button getButton(){
            return button;
        }
}
