# AGENTS & Autonomous Tool Conventions

## Project Rules & Java Architecture Invariants

1. **Java Coding Guidelines (AIR Standard):**
   - Use explicit type declarations — avoid `var` for enhanced readability.
   - Keep methods small and focused (under 20 lines when possible).
   - Use meaningful names for all identifiers (variables, methods, classes).
   - Handle exceptions with specific exception types; avoid catching generic `Exception`.
   - Prefer immutability where possible (`final` fields, unmodifiable collections).
   - Apply DRY (Don't Repeat Yourself) principle — extract common code.
   - Validate all inputs with proper null checks and range validation.
   - Follow standard Java naming conventions: PascalCase for classes, camelCase for methods and variables.

2. **Compilation & Execution:**
   - Standard command line compilation: `javac <FileName>.java`.
   - Execution: `java <FileName>`.
   - Always close resources properly using try-with-resources for `AutoCloseable` objects (like `Scanner`).

3. **Autonomous Vibe-Coding Invariants:**
   - Never break existing algorithms' output formats when refactoring.
   - Do not add heavy external dependencies (keep standard JDK libraries).
