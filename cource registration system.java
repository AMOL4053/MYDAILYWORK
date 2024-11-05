package mypack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledCount = 0;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - enrolledCount;
    }

    public boolean enrollStudent() {
        if (enrolledCount < capacity) {
            enrolledCount++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() {
        if (enrolledCount > 0) {
            enrolledCount--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + ", Title: " + title + ", Description: " + description +
                ", Schedule: " + schedule + ", Available Slots: " + getAvailableSlots();
    }
}

class Student {
    private String studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (!registeredCourses.contains(course) && course.enrollStudent()) {
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.getTitle());
        } else {
            System.out.println("Could not register for " + course.getTitle() + ". It may be full or already registered.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course) && course.dropStudent()) {
            System.out.println("Successfully dropped " + course.getTitle());
        } else {
            System.out.println("Could not drop " + course.getTitle() + ". You may not be registered for this course.");
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name;
    }
}

public class CourseDatabaseApp {
    private static HashMap<String, Course> courses = new HashMap<>();
    private static HashMap<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data
        courses.put("CS101", new Course("CS101", "Intro to Computer Science", "Basics of CS", 3, "MWF 10-11AM"));
        courses.put("MATH201", new Course("MATH201", "Calculus I", "Differential and Integral Calculus", 2, "TTh 9-10:30AM"));
        students.put("S001", new Student("S001", "Alice"));
        students.put("S002", new Student("S002", "Bob"));

        while (true) {
            System.out.println("\n--- Course Registration System ---");
            System.out.println("1. List all courses");
            System.out.println("2. Register student for a course");
            System.out.println("3. Drop a course for a student");
            System.out.println("4. Show student info and registered courses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerStudentForCourse(scanner);
                    break;
                case 3:
                    dropCourseForStudent(scanner);
                    break;
                case 4:
                    showStudentInfo(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listCourses() {
        System.out.println("\n--- Available Courses ---");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    private static void registerStudentForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to register: ");
        String courseCode = scanner.nextLine();
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.registerCourse(course);
    }

    private static void dropCourseForStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to drop: ");
        String courseCode = scanner.nextLine();
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.dropCourse(course);
    }

    private static void showStudentInfo(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n--- Student Info ---");
        System.out.println(student);
        System.out.println("Registered Courses:");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println("  - " + course.getTitle() + " (" + course.getCode() + ")");
        }
    }
}
