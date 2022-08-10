/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myUploads;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class myUploads {
        private SimpleStringProperty fileName; 
        private SimpleStringProperty courseName;
        private SimpleStringProperty topic;
        private Button button;
  
        myUploads(String fileName,String topic,String courseName,Button button){
                this.fileName = new SimpleStringProperty (fileName);
                this.topic = new SimpleStringProperty (topic);
                this.courseName = new SimpleStringProperty (courseName);
                this.button = button;
                this.button.setText("Enter");
        }
        
         public String getFileName(){
                return fileName.get();
        }
         
        public void setFileName(String fileName){
            this.fileName.set(fileName);
        }
        
         public String getCourseName(){
                return courseName.get();
        }
         
        public void setCourseName(String courseName){
            this.courseName.set(courseName);
        }
        
         public String getTopic(){
                return topic.get();
        }
         
        public void setTopic(String topic){
            this.topic.set(topic);
        }
        
        public void setButton(Button button){
            this.button = button;
        }
        public Button getButton(){
                return button;
        }

}
