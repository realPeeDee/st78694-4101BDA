package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import java.util.Scanner;
//all libraries needed
public class Main {
    public static Logger logger = Logger.getGlobal();
    public static Scanner scanner = new Scanner(System.in);
    public static Saver loader=new Saver();
    private static boolean isEnd=false;

    public static void main(String[] args) {
        Students studentList;
        studentList=loader.readFromFile();
        if(studentList==null) {
            studentList = new Students();
        }
        while (!isEnd){
            mainMenuText();
            mainMenuFunction(studentList);
        }
        loader.writeToFile(studentList);
    }
    public static void mainMenuText(){ //all functions of program
        System.out.println("Press 1 to Add new student");
        System.out.println("Press 2 to Delete data about student");
        System.out.println("Press 3 to Save added data");
        System.out.println("Press 4 to Find student");
        System.out.println("Press 5 to Exit");
    }
    public static void mainMenuFunction(Students studentList){ //function selection
        String input;
        List<String> possibleInputs= Arrays.asList("1", "2", "3", "4","5");
        scanner=new Scanner(System.in);
        while(true) {
            input = Main.scanner.nextLine();
            if ((possibleInputs.contains(input))) {
                break;
            }
            else{
                System.out.println("Enter number 1-5"); //in case of mistake
            }
        }
        switch (input){
            case "1":
                studentList.add();
                break;
            case "2":
                studentList.remove();
                break;
            case "3":
                Main.loader.createAReport(studentList);
                break;
            case "4":
                studentList.searchAndShowStudent();
                break;
            case "5":
                isEnd=true;
                break;
        }
    }
}