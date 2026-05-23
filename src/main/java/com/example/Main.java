package com.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Grade: ");
                    String grade = sc.nextLine();

                    dao.addStudent(name, age, grade);
                    break;

                case 2:
                    dao.showStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    dao.searchStudent(id);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("Enter ID: ");
                    int upid = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter New Name: ");
                    String new_name = sc.nextLine();

                    System.out.println("Enter New Age: ");
                    int new_age = sc.nextInt();

                    System.out.println("Enter New Grade: ");
                    int new_grade = sc.nextInt();

                    dao.updateStudent(upid, new_name, new_age, new_grade);

                    break;

                    case 6:
                        System.exit(0);
                        break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}