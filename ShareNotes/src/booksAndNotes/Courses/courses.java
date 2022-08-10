package booksAndNotes.Courses;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class courses {
        private SimpleStringProperty courseTitle;
        private SimpleStringProperty courseCode;
        private SimpleStringProperty credit;
        private Button button;
        
        
        courses(String courseTitle,String courseCode, String credit, Button button)
        {
                this.courseTitle= new SimpleStringProperty (courseTitle);
                this.courseCode =new SimpleStringProperty ( courseCode);
                this.credit  =new SimpleStringProperty ( credit);      
                this.button = button;
                this.button.setText ("Enter");
        }
        
        
        public String getCourseTitle(){
                return courseTitle.get();
        }
        public String getCourseCode(){
                return courseCode.get();
        }
        public String getCredit(){
                return credit.get();
        }
        public void setCourseCode(String courseCode){
            this.courseCode.set(courseCode);
        }
        public void setCredit(String credit){
            this.credit.set(credit);
        }

        public void setCourseTitle(String courseTitle){
            this.courseTitle = new SimpleStringProperty(courseTitle);
        }
        public void setButton(Button button){
            this.button = button;
        }
        public Button getButton(){
            return button;
        }
}
