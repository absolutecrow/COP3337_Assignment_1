/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337_assignment_1;

import java.util.ArrayList;

/**
 *
 * @author AbsoluteCrow
 */
public class Admissions 
{
    private ArrayList<Student> studentRecords = new ArrayList<Student>();
    private ArrayList<Student> droppedStudents = new ArrayList<Student>();
    
    public void addStudent(Student student)
    {
        studentRecords.add(student);
    }
    
    public ArrayList<Student> getRecords()
    {
        return studentRecords;
    }
    
    public int sizeOfRecords()
    {
        return studentRecords.size();
    }
    
    //Drop a student
    public void dropStudent(Student student)
    {      
        for (int i = 0; i < studentRecords.size(); i++)
        {
            if (studentRecords.get(i).getIDnumber().equals(student.getIDnumber()))
            {
                droppedStudents.add(studentRecords.get(i));
                studentRecords.remove(i);
            }
        }
    }
    
    //Checking if the ID of a student exist in both list
    public boolean doesStudentExist(String studentID)
    {
        for (int i = 0; i < studentRecords.size(); i++)
        {
            if (studentRecords.get(i).getIDnumber().equals(studentID))
            {
                return true;
            }
        }
        for (int i = 0; i < droppedStudents.size(); i++)
        {
            if (droppedStudents.get(i).getIDnumber().equals(studentID))
            {
                return true;
            }
        }
        return false;
    }
    
    //To get the location of a student in the studentRecords list.
    //As this is used for modification of the courses they are taken
    //We are only going to be using studentRecords and ignoring droppedStudents
    public int whatStudent(String studentID)
    {
        for (int i = 0; i < studentRecords.size(); i++)
        {
            if (studentRecords.get(i).getIDnumber().equals(studentID))
            {
                return i;
            }
        }
        return -1;
    }
    
    public int sizeOfDroppedRecords()
    {
        return droppedStudents.size();
    }
    
    public ArrayList<Student> getDroppedStudents()
    {
        return droppedStudents;
    }
    
    //Check to remove the student from the registry from either
    //dropped students or current students.
    public void removeStudent(Student student)
    {      
        for (int i = 0; i < studentRecords.size(); i++)
        {
            if (studentRecords.get(i).getIDnumber().equals(student.getIDnumber()))
            {
                studentRecords.remove(i);
            }           
        }
        
        for (int i = 0; i < droppedStudents.size(); i++)
        {
            if (droppedStudents.get(i).getIDnumber().equals(student.getIDnumber()))
            {
                droppedStudents.remove(i);
            }
        }
    }
}
