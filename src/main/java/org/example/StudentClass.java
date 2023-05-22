package org.example;

import java.io.Serializable;
import java.time.LocalDate;
//all libraries needed
public class StudentClass implements Serializable{
    public String name;
    public String ID;
    public String email;
    public LocalDate dateofbirth;

    public StudentClass(String name, String studentID, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.ID = studentID;
        this.email = email;
        this.dateofbirth = dateOfBirth;
    }
    public StudentClass() {
    }
    @Override
    public String toString(){
        return this.name+"\n"+this.ID+"\n"+this.email+"\n"+this.dateofbirth;
    }
}

