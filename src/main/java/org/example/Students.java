package org.example;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
//all libraries needed
public class Students implements Serializable {
    private List<StudentClass> students=new ArrayList<>();
    public void add(){ //adding function for students
        StudentClass student=new StudentClass();
        System.out.println("Name:");
        student.name=Main.scanner.nextLine();
        System.out.println("ID:");
        student.ID=Main.scanner.nextLine();
        System.out.println("Email:");
        student.email=Main.scanner.nextLine();
        System.out.println("Date of birth");
        try {
            System.out.println("Year:");
            int year = Main.scanner.nextInt();
            System.out.println("Month:");
            int month = Main.scanner.nextInt();
            System.out.println("Day:");
            int day=Main.scanner.nextInt();
            student.dateofbirth=LocalDate.of(year,month,day);
            students.add(student);
            Main.logger.info("Student added successfully");
        }
        catch (DateTimeException e){
        }
        catch (InputMismatchException e){
            Main.logger.info("Invalid input");
        }
    }

    public void remove(){ //removing function
        System.out.println("ID of student:");
        String id=Main.scanner.nextLine();
        try {
            StudentClass searchedStudent=search(id);
            students.remove(searchedStudent);
            Main.logger.info("Student deleted successfully");
        }
        catch (Exception e){
        }
    }
    public StudentClass search(String id){ //searching function
        StudentClass searchedStudent;
        try{
            searchedStudent=students.stream().filter(student -> student.ID.equals(id)).findAny().get();
            return searchedStudent;
        }
        catch (Exception e){
            return null;
        }
    }
    public void searchAndShowStudent(){ //prints the found results
        System.out.println("ID of student:");
        String id=Main.scanner.nextLine();
        try {
            StudentClass foundStudent=search(id);
            System.out.println(foundStudent);
        }
        catch (Exception e){
        }
    }
    public List<StudentClass> getStudents() {
        return students;
    }
}
