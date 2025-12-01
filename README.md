Student Management System

Java Lab Assignment 3 – Exception Handling, Multithreading & Wrapper Classes

📌 Overview

This project is a Java-based Student Management System designed as part of Lab Assignment 3.
The application demonstrates:

- Exception Handling
- Multithreading
- Wrapper Classes
- Custom Exceptions
- Proper Class Hierarchy

It provides a simple console interface to add and display student records with robust validation and a loading simulation.

---

📁 Features Implemented

✅ 1. Exception Handling

The program handles:

- Invalid input types
- Empty fields (name, course, email)
- Marks outside valid range (0–100)
- Missing student record lookup
- Custom exception "StudentNotFoundException"

✅ 2. Multithreading

A separate thread ("Loader" class) simulates a loading process using:

Thread t = new Thread(new Loader());
t.start();

✅ 3. Wrapper Classes

Uses:

- "Integer" for roll number
- "Double" for marks

Autoboxing is used during input conversions.

✅ 4. Class Hierarchy

- "StudentManagementSystem" → Main class
- "StudentManager" → Implements "RecordActions"
- "Student" → Data model
- "Loader" → Implements "Runnable"
- "StudentNotFoundException" → Custom exception
- "RecordActions" → Interface

---

📌 How the Program Works

▶ Adding a Student

- User enters roll no, name, email, course, and marks.
- All fields are validated.
- A loading animation is shown using threads.
- Student is stored in a HashMap.

▶ Viewing a Student

- Enter a roll number.
- If the record exists, full details with grade are displayed.
- Otherwise, "StudentNotFoundException" is thrown.

---

📂 Files Included

StudentManagementSystem.java

---

🛠 Technologies Used

- Java
- OOP Concepts
- Multithreading
- Exception Handling

---

📷 Sample Output

Enter Roll No (Integer): 102
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 77.5
Loading.....
Student added successfully!

Enter roll no to display details: 102

Roll No: 102
Name: Karan
Email: karan@mail.com
Course: BCA
Marks: 77.5
Grade: B

Program execution completed.

---

📌 Learning Outcomes

By completing this assignment, you will understand:

- How to create and throw custom exceptions
- How to implement multithreading in Java
- How to use wrapper classes and autoboxing
- How to build a structured class hierarchy

---
