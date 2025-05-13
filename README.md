# 📚 Learning Management System (LMS) – Java Console Application

A simple **console-based LMS** written in **Java** to demonstrate core **Object-Oriented Programming (OOP)** principles such as **encapsulation**, **inheritance**, **polymorphism**, and **abstraction**.

---

## 🎯 Objective

This project simulates a basic LMS environment where users can log in as **Admin**, **Instructor**, or **Student** and perform role-specific operations in a text-based interface.

---

## 👨‍💻 Technologies Used

- Java (JDK 8+)
- Console I/O (Scanner)
- JSON-like Output (for simulated data export)
- Basic Java Collections (ArrayList)

---

## 🧠 OOP Concepts Demonstrated

✅ Encapsulation – Private fields with getters and setters  
✅ Inheritance – `User` as a base class for `Admin`, `Instructor`, `Student`  
✅ Polymorphism – Dynamic method behavior based on user role  
✅ Abstraction – `User` as an abstract base class with abstract methods

---

## 🔧 Features

### 👤 Admin
- Add new courses
- Assign instructors to courses
- View all courses
- Export course data (JSON-like format)

### 👨‍🏫 Instructor
- Add content to assigned courses
- Assign grades to students

### 🎓 Student
- View available courses
- View course content
- View assigned grades

---

## 📂 Project Structure

```plaintext
LMS.java           # Main controller with menus
User.java          # Abstract base class
Admin.java         # Admin-specific features
Instructor.java    # Instructor-specific features
Student.java       # Student-specific features
Course.java        # Course model with content & grade
Main.java          # Entry point of the application
