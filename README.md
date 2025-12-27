# 📘 LearnTrack – Student, Course & Enrollment Management System
*A Console-Based Java Application*

LearnTrack is a **menu-driven console application** built in **Core Java**, designed to manage:

- **Students**
- **Courses**
- **Enrollments**

The project demonstrates **fundamental Java concepts**, clean modular design, and a complete in-memory management workflow.

---

## 🔥 Key Functional Highlights

This project provides comprehensive operational flow among students, courses, and enrollments:

### ✔ Student Features
- Add a new student
- Remove a student
- Update student email
- View all students
- View individual student details

### ✔ Course Features
- Add a new course
- Activate / Deactivate a course
- View course details
- List **active**, **inactive**, and **all** courses
- Delete a course

### ✔ Enrollment Features
- Enroll student into a **course that is ACTIVE**
- List all enrollments
- List enrollments filtered by **Active / Completed / Cancelled**
- List enrollments for a specific student
- Change enrollment status (Active → Completed / Cancelled)

---

## ⚙️ Important Behavioral Rules

### 📌 1. A student becomes ACTIVE only when enrolled in a course
- In the `Enrollment` constructor: `student.setActive(true);`
- Adding a student does **not** activate them.
- Only enrollment makes the `active` flag `true`.

### 📌 2. Changing an enrollment status affects student active flag
When the enrollment status changes to COMPLETED or CANCELLED, the code invokes:  
`student.setActive(false);`

| Enrollment Status | Student Active |
|------------------|----------------|
| ACTIVE           | true           |
| COMPLETED        | false          |
| CANCELLED        | false          |

### 📌 3. A student may be enrolled ONLY if:
- The student exists
- The course exists
- **The course is ACTIVE**

Inactive courses cannot accept enrollments.

### 📌 4. Courses control enrollment availability
- Active courses → enrollment allowed
- Inactive courses → enrollment blocked

### 📌 5. Students are permanently deleted
The system uses `removeStudent()` for deletion. This removes the record completely; there is no soft deletion or deactivation.

### 📌 6. All data is stored in-memory
All information resets when the application restarts.

---

## 🏛️ Architecture Overview

```
src/
 └── com.airtribe.learntrack
      ├── entity        # Student, Course, Enrollment, Person, Trainer
      ├── service       # StudentService, CourseService, EnrollmentService
      ├── repository    # In-memory storage
      ├── util          # InputCollector, Validator, Display Services, IdGenerator
      ├── enums         # CourseStatus, EnrollmentStatus
      ├── constants     # Menu strings
      └── ui            # Menu (entry point)
docs/
 ├── Setup_Instructions.md
 ├── JVM_Basics.md
 └── Design_Notes.md
```

---

## ▶️ How to Compile and Run

### 1. Compile all Java files
```bash
javac -d out $(find . -name "*.java")
```

### 2. Run the application
```bash
java -cp out com.airtribe.learntrack.ui.Menu
```

---

## 🧪 Sample User Flow

### ➤ Add Student → Activate Course → Enroll → Change Status
1. Add a student
2. Add a course (default inactive)
3. Activate the course
4. Enroll student → student becomes **active**
5. Mark COMPLETE → student becomes **inactive**

### ➤ Try enrolling in inactive course
- Error message appears if enrollment is attempted in a course that is not active.

---

## 📚 Technologies Used

- Java 1.8
- Console I/O
- No external dependencies

---

## 📄 Purpose

LearnTrack was created as a demonstration of:

- OOP principles (inheritance, polymorphism, encapsulation)
- Collections (ArrayList)
- Static utility patterns
- Exception handling
- Console-based menus and modular class design

---

## 🙌 Author

Developed for Java learning and practice.