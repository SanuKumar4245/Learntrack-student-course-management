## 1. What is JDK?
**JDK (Java Development Kit)** is the complete toolkit used by developers to **write, compile, debug, and run Java applications**.  
It includes:

- **javac** – the Java compiler (converts `.java` files to bytecode)
- **JRE (Java Runtime Environment)**
- Development tools (debugger, javadoc, etc.)

Used mainly by **developers**.

---

## 2. What is JRE?
**JRE (Java Runtime Environment)** provides everything needed to **run** Java programs but **not** to develop them.

It contains:

- **JVM** (Java Virtual Machine)
- Core Java class libraries
- Supporting runtime files

Used by anyone who **runs** Java applications.

---

## 3. What is JVM?
**JVM (Java Virtual Machine)** is a virtual machine that executes Java **bytecode**.  
It performs tasks such as:

- Converting bytecode into **machine‑specific instructions**
- Managing memory, garbage collection, and program execution

Each operating system (Windows, macOS, Linux) has its own JVM implementation, but all JVMs follow the same specification, which keeps Java platform‑independent.

---

## 4. What is Bytecode?
When you compile a Java program using `javac`, the compiler generates a `.class` file.  
This file contains **bytecode**, which is:

- Not tied to any operating system
- Platform‑independent
- Understood by the JVM

---

## 5. What does “Write Once, Run Anywhere” mean?
Java’s slogan **“Write Once, Run Anywhere” (WORA)** means that once a Java program is written and compiled into **bytecode**, the same compiled file can run on **any device or operating system** that has a **JVM**.

You do **not** need to recompile the program for Windows, macOS, or Linux.  
Each platform has its own JVM, and that JVM converts the same bytecode into machine code suitable for that system.

Because bytecode is platform‑independent and JVM handles execution, Java programs can run anywhere—even across different operating systems—with no code changes.

---
