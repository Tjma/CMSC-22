/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcs-madl13
 */
import java.io.Serializable;

public class Course implements Serializable{
    private String courseCode; // CMSC 22
    private String courseDescription; // OOP
    
    public Course(String courseCode, String courseDescription){
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }
    
    public String getCourseCode(){
        return courseCode;
    }
    
    public void setCourseCode(String cCode){
        this.courseCode = cCode;
    }
    
    public String getCourseDescription(){
        return courseDescription;
    }
    
   public void setCourseDescription(String cDescription){
       this.courseDescription = cDescription;
   }
}
