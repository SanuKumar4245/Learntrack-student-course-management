# Design Notes

---

## 1. Why ArrayList Instead of Array?

- **Dynamic Size:** `ArrayList` grows and shrinks as needed, while arrays are fixed-size.
- **Convenience:** Built-in methods (`add`, `remove`) make list management simple.
- **Clarity:** No need to manage indices or capacity manually.

---

## 2. Where Static Members Were Used and Why

- **ID Generation:** `IdGenerator` uses static counters and methods to ensure unique IDs shared app-wide.
- **Service Instances:** `ServiceHandler` holds static service objects so only one instance of each exists.
- **Utilities:** `InputCollector` and `InputValidator` contain only static methods for global utility.

---

## 3. Where Inheritance and Interfaces Were Used

- **Entities:**
    - `Person` is the abstract base class for `Student` and `Trainer` (common identity fields & custom behavior).
    - `Student` extends `Person`, adds `active` status logic.
    - `Trainer` (abstract) extends `Person`, allowing future trainer-specific code.
- **Display System:**
    - `DisplayServices` is an interface implemented by `ConsoleDisplayService` and `LoggerDisplayService`.
    - Allows flexible output: printing to console or (extensible) logging.
- **Exception:**
    - `InvalidInputException` extends `Exception` for input validation errors.

**Benefits:** Code reuse, consistent structure, easy future extension, and support for multiple output implementations.

---