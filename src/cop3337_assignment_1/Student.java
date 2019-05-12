/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337_assignment_1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AbsoluteCrow
 */
public class Student 
{
    Name name = new Name();
    Address address = new Address();
    Date date = new Date();
    String[] courses = new String[5];
    private ArrayList<String> courseList = new ArrayList<String>();   
    private String idNumber;
    
    public void setIDnumber(String id)
    {
        this.idNumber = id;
    }
    
    public String getIDnumber()
    {
        return this.idNumber;
    }
    
    //Add courses to the courses arraylist if its not null
    public void setCourses(String[] requestedCourses)
    {
        for (int i = 0; i < requestedCourses.length; i++)
        {
            if (!requestedCourses[i].isEmpty())
                courseList.add(requestedCourses[i]);
        }
    }
    
    public void addCourse(String course)
    {
        courseList.add(course);
    }
    
    public ArrayList<String> getCourses()
    {       
        return courseList;
    }   
    
    public void removeCourse(String course)
    {
        courseList.remove(course);
    }
    
}