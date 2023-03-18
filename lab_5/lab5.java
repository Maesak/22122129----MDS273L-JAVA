import java.util.Scanner;

class Student {
    String regNo;
    String name;
    String email;
    String phone;
    String studentClass;
    String department;
    
    public Student(String regNo, String name, String email, String phone, String studentClass, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
        this.department = department;
    }
    
    public void printDetails() {
        System.out.println("Reg. No.: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + studentClass);
        System.out.println("Department: " + department);
    }
}

public class lab5 {
    public static void main(String[] args) {
        Student[] students = new Student[100];
        int numStudents = 0;
        
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    if (numStudents >= students.length) {
                        System.out.println("Cannot add more students. Database is full.");
                    } else {
                        System.out.print("Enter registration number: ");
                        String regNo = input.nextLine();
                        
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        
                        System.out.print("Enter email: ");
                        String email = input.nextLine();
                        
                        System.out.print("Enter phone: ");
                        String phone = input.nextLine();
                        
                        System.out.print("Enter class: ");
                        String studentClass = input.nextLine();
                        
                        System.out.print("Enter department: ");
                        String department = input.nextLine();
                        
                        Student newStudent = new Student(regNo, name, email, phone, studentClass, department);
                        students[numStudents] = newStudent;
                        numStudents++;
                        
                        System.out.println("Student added to database.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Search for a student:");
                    System.out.print("Enter registration number or name: ");
                    String searchKey = input.nextLine();
                    
                    boolean found = false;
                    for (int i = 0; i < numStudents; i++) {
                        Student student = students[i];
                        if (student.regNo.equals(searchKey) || student.name.equalsIgnoreCase(searchKey)) {
                            student.printDetails();
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("No student found with the given search key.");
                    }
                    break;
                    
                case 3:
                    if (numStudents == 0) {
                        System.out.println("No students in database.");
                    } else {
                        System.out.println("Details of all students:");
                        for (int i = 0; i < numStudents; i++) {
                            Student student = students[i];
                            student.printDetails();
                            System.out.println("----------------------");
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
            }
        }
    }
         


