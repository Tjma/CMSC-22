//package studentdb;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentDB {

    private static final String save = "save.ser";

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> registeredStudents = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int select;

        //Deserialization
        try {
            File fin = new File(save);
            if (fin.length() == 0) {
                // if walay sulod ang file
                System.err.println("FILE IS EMPTY");
            } else {
                fis = new FileInputStream(fin);
                ois = new ObjectInputStream(fis);
                registeredStudents = (List<Student>) ois.readObject();
                System.out.print(registeredStudents);

                ois.close();
            }

        } catch (ClassNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            System.out.println("STUDENT DATABASE");
            System.out.println("Key in the corresponding number of the procedure you wanted: ");
            System.out.println("\t(1) Register\n\t(2) View Student Directory\n\t(3) Deregister\n\t(4) Edit Student Info\n\t(5) Student List View\n\t(6) *SAVE* \n\t(7) Exit");
            select = sc.nextInt();

            if (select == 1) {
                System.out.println("Register");
                System.out.println("Enter student number(YYYYxxxxx format): ");
                String x = sc.nextLine();
                String studentNumber = sc.nextLine();
                System.out.println("Enter the following: ");
                System.out.print("* First Name: ");
                String fn = sc.nextLine();
                System.out.print("* Middle Initial: ");
                char mi = sc.nextLine().charAt(0);
                System.out.print("* Last Name: ");
                String ln = sc.nextLine();
                System.out.print("* Degree Program: ");
                String dp = sc.nextLine();
                System.out.print("* Year Level: ");
                int level = sc.nextInt();
                sc.nextLine();

                System.out.print("* Course Code: ");
                String courseCode = sc.nextLine();
                System.out.print("* Crush Name: ");
                String crushName = sc.nextLine();

                System.out.print("* Favorite Subject: ");
                String favSubject = sc.nextLine();
                Course fav = new Course(courseCode, favSubject);
                Student student = new Student(studentNumber, fn, mi, ln, dp, level, crushName, fav);
                registeredStudents.add(student);
                System.out.println("NEW STUDENT");
                System.out.println(student);
            }

            if (select == 2) {
                System.out.println("Enter student number(YYYYxxxxx format): ");
                String x = sc.nextLine(); // someone told me why unsa ni nganong maboang ang code without this
                String sn = sc.nextLine();
                boolean exists = false;
                for (int i = 0; i < registeredStudents.size(); i++) {
                    if (registeredStudents.get(i).getStudentNumber().equals(sn)) {
                        System.out.print(registeredStudents.get(i) + "\n\n");
                        exists = true;
                        break;
                    }
                }
                if (exists == false) {
                    System.out.print("Student not found.");
                }
            }

            if (select == 3) {
                System.out.println("Enter student number(YYYYxxxxx format): ");
                String x = sc.nextLine();
                String stn = sc.next();
                boolean existing = false;
                for (int i = 0; i < registeredStudents.size(); i++) {
                    if (registeredStudents.get(i).getStudentNumber().equals(stn)) {
                        registeredStudents.remove(i);
                        existing = true;
                        System.out.println("SUCCESS!");
                        break;
                    }
                }
                if (existing == false) {
                    System.out.println("Student not found.\n");
                }
            }

            if (select == 4) {
                System.out.print("Enter student number: ");
                String x = sc.nextLine();
                String stno = sc.nextLine();
                boolean uneditable = true;
                for (int i = 0; i < registeredStudents.size(); i++) {
                    if (registeredStudents.get(i).getStudentNumber().equals(stno)) {
                        System.out.println("STUDENT PROFILE\n" + registeredStudents.get(i));
                        System.out.println("UPDATE FIELDS:\n");
                        System.out.println("STUDENT NUMBER: " + registeredStudents.get(i).getStudentNumber());
                        System.out.print("Edit First Name: ");
                        registeredStudents.get(i).setFirstName(sc.nextLine());
                        System.out.print("Edit Middle Initial: ");
                        registeredStudents.get(i).setMiddleInitial(sc.nextLine().charAt(0));
                        System.out.print("Edit Last Name: ");
                        registeredStudents.get(i).setLastName(sc.nextLine());
                        System.out.print("Edit Degree Program: ");
                        registeredStudents.get(i).setCourse(sc.nextLine());
                        System.out.print("Update Year Level: ");
                        registeredStudents.get(i).setYearLevel(sc.nextInt());
                        System.out.print("Update Crush Name: ");
                        registeredStudents.get(i).setCrushName(sc.nextLine());
                        System.out.print("Update Course Code: ");
                        registeredStudents.get(i).getFaveSubject().setCourseCode(sc.nextLine());
                        System.out.print("Update Course Description: ");
                        registeredStudents.get(i).getFaveSubject().setCourseDescription(sc.nextLine());

                        System.out.println("INFORMATION UPDATED!\nSTUDENT PROFILE\n" + registeredStudents.get(i));
                        uneditable = false;
                        break;
                    }
                }
                if (uneditable == true) {
                    System.out.println("Student not found");
                }
            }

            if (select == 5) {
                System.out.println("STUDENT DIRECTORY");
                for (int i = 0; i < registeredStudents.size(); i++) {
                    System.out.print(registeredStudents.get(i));
                    System.out.println("-");
                }
            }

            if (select == 6) {
                try {
                    //Serialization
                    File fout = new File(save);
                    fos = new FileOutputStream(fout);
                    oos = new ObjectOutputStream(fos);

                    oos.writeObject(registeredStudents);

                    oos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException es) {
                    es.printStackTrace();

                }
            }
        } while (select != 7);
        System.out.println("Thank you! Program terminated.");
    }
}
