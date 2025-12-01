import java.util.*;

// ------------------ Custom Exception ---------------------
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// ------------------ Loader Class (Thread) ----------------
class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading Interrupted!");
        }
    }
}

// ------------- Interface for Actions ---------------------
interface RecordActions {
    void addStudent() throws StudentNotFoundException;
    void displayStudent(int rollNo) throws StudentNotFoundException;
}

// ------------------ Student Class ------------------------
class Student {
    Integer rollNo;   // Wrapper class
    String name, email, course;
    Double marks;     // Wrapper class
    char grade;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private char calculateGrade(double m) {
        if (m >= 90) return 'A';
        else if (m >= 80) return 'B';
        else if (m >= 70) return 'C';
        else if (m >= 60) return 'D';
        else return 'F';
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}

// ------------------ Student Manager ----------------------
class StudentManager implements RecordActions {

    private final HashMap<Integer, Student> records = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer rollNo = Integer.valueOf(sc.nextInt());   // Autoboxing
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) throw new Exception("Name cannot be empty!");

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            if (email.isEmpty()) throw new Exception("Email cannot be empty!");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            if (course.isEmpty()) throw new Exception("Course cannot be empty!");

            System.out.print("Enter Marks: ");
            Double marks = Double.valueOf(sc.nextDouble());
            if (marks < 0 || marks > 100)
                throw new Exception("Marks must be between 0 and 100!");

            // Thread for loading
            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            Student st = new Student(rollNo, name, email, course, marks);
            records.put(rollNo, st);

            System.out.println("Student added successfully!\n");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type! Enter correct values.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operation completed.\n");
        }
    }

    @Override
    public void displayStudent(int rollNo) throws StudentNotFoundException {
        if (!records.containsKey(rollNo))
            throw new StudentNotFoundException("Student with Roll No " + rollNo + " not found!");

        records.get(rollNo).display();
    }
}

// ------------------ Main Class (Updated) ---------------------------
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            manager.addStudent();

            System.out.print("Enter roll no to display details: ");
            int r = sc.nextInt();

            manager.displayStudent(r);

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProgram execution completed.");
    }
}
