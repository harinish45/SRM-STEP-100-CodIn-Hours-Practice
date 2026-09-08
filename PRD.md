# Product Requirements Document (PRD)

## Project: SRM STEP 100 Coding Hours Practice Suite

### 1. Vision & Purpose
A structured, zero-dependency Java 17+ repository demonstrating foundational computational thinking, algorithm design, data structures, and cybersecurity modeling exercises developed during the SRM Institute of Science & Technology (SRMIST) 100 Coding Hours curriculum.

### 2. Scope & Target Categories
- **Cryptographic & Security Foundations:** `PasswordAnalyzer.java`, `OTPGenerator.java`, string hashing & validation utilities.
- **Mathematical Modeling:** `CollatzSequence.java`, `Fibonacci.java`, `ArmstrongNumber.java`, `Quadratic.java`, `MatrixOperations.java`.
- **String Parsing & Text Processing:** `TextCompressor.java`, `SpellChecker.java`, `PalindromeCheck.java`, `UniqueCharacters.java`.
- **System Simulation & Real-World Algorithms:** `RockPaperScissors.java`, `StudentGradeCalculator.java`, `VotingEligibility.java`, `WindChillCalculator.java`.

### 3. Architecture & Build Standards
- **Runtime:** Java 17+ (LTS).
- **Compilation Standard:** Zero external dependencies; standard `javac` and `java` execution.
- **Modularity:** Isolated executable classes with explicit inputs, validation guards, and readable output telemetry.

### 4. Non-Functional Requirements
- **Performance:** $O(1)$ memory overhead where possible; avoid superfluous object allocations.
- **Robustness:** Input validation against null or malformed command-line arguments.
- **Maintainability:** Documented time and space complexity headers for each algorithm.
