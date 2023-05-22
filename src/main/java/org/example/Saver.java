package org.example;

import java.io.*;
import java.util.List;
//all libraries needed
public class Saver {
    public void writeToFile(Students studentList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("save.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(studentList);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void createAReport(Students studentList){
        List<StudentClass> students=studentList.getStudents();
        try {
            FileWriter myWriter = new FileWriter("database.txt"); //.txt file with output
            for (StudentClass student :
                    students) {
                myWriter.write(student.toString());
                myWriter.write("\n");
            }
            myWriter.close();
        }
        catch (Exception ex) {
        }
    }
    public Students readFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("save.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Students list = (Students) objectIn.readObject();

            objectIn.close();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
}
