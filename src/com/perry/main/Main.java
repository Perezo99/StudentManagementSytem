package com.perry.main;

import com.perry.dao.StudentDao;
import com.perry.dao.StudentDaoInterface;
import com.perry.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDaoInterface dao = new StudentDao();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome To Perry Student Management System");
        while (true){
            System.out.println(
                    "\n1.Add Student" +
                            "\n2.Show All Students" +
                            "\n3.Get Student based on roll number" +
                            "\n4.Update Student" +
                            "\n5.Delete Student" +
                            "\n6.Exit"
            );
            System.out.println("Enter Choice");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Add Student");
                    System.out.println("Enter Student Name");
                    String name = in.next();
                    System.out.println("Enter College Name");
                    String collegeName = in.next();
                    System.out.println("Enter City");
                    String city = in.next();
                    System.out.println("Enter Percentage");
                    double percentage = in.nextDouble();
                    Student st = new Student( name, collegeName, city, percentage);
                    boolean ans = dao.insertStudent(st);
                    if (ans){
                        System.out.println("Record Added Successfully :)");
                    } else {
                        System.out.println("Something Went Wrong :(");
                    }
                    break;
                case 2:
                    System.out.println("Show All Students");
                    dao.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get Student based on roll number");
                    System.out.println("Enter roll number");
                    int roll = in.nextInt();
                    boolean f = dao.showStudentById(roll);
                    if(!f) {
                        System.out.println("Student with this id number is not available on our system.");
                    } else {
                        System.out.println("Here we go");
                    }
                    break;
                case 4:
                    System.out.println("Update Student");
                    System.out.println("\n1.Update Name \n2. Update College Name");
                    System.out.println("Enter your choice");
                    int co = in.nextInt();
                    if (co == 1){
                        System.out.println("Enter roll number");
                        int rnum = in.nextInt();
                        System.out.println("Enter new name");
                        String sname = in.next();
                        Student stu = new Student();
                        stu.setName(sname);
                        boolean flag = dao.update(rnum, sname, co, stu);
                        if (flag){
                            System.out.println("Name Updated Successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                    }
                    if (co == 2){
                        System.out.println("Enter roll number");
                        int rnum = in.nextInt();
                        System.out.println("Enter new College");
                        String sname = in.next();
                        Student stu = new Student();
                        stu.setName(sname);
                        boolean flag = dao.update(rnum, sname, co, stu);
                        if (flag){
                            System.out.println("College Updated Successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Delete Student");
                    System.out.println("Enter Roll Number To Delete");
                    int rolls = in.nextInt();
                    boolean d = dao.delete(rolls);
                    if (d){
                        System.out.println("Record Deleted Successfully");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the app, see you next time. :) ");
                    System.exit(0);
                default:
                    System.out.println("Please enter valid choice...");
            }
        }
    }
}