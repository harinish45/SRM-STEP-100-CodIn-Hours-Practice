# Engineering Roadmap & AI Pair-Programming Tasks (TODO)

## 📌 Autonomous Vibe-Coding Checklist

### Phase 1: Code Standardization & Cleanup
- [ ] Refactor duplicate filenames: consolidate `RockPaperScissors.java.java` into `RockPaperScissors.java`.
- [ ] Clean up redundant rework files: review `LargestAndSecondLargestrework.java` and `StudentGradeCalculatorrework.java` to keep optimal implementations.
- [ ] Add Javadoc headers with `@author`, `@version`, and Time/Space complexity to all problem files.

### Phase 2: Packaging & Build System
- [ ] Group source files into clean packages:
  - `com.srm.math.*` (Numerical algorithms)
  - `com.srm.strings.*` (Text & string parsing)
  - `com.srm.security.*` (Password and OTP analyzers)
  - `com.srm.games.*` (Simulations and games)
- [ ] Add standard `build.sh` and `build.bat` scripts for one-command batch compilation.

### Phase 3: Automated Testing
- [ ] Add JUnit 5 test suite covering edge cases (e.g., negative inputs, empty strings, integer overflow).
- [ ] Add GitHub Actions CI workflow to verify `javac *.java` passes on every pull request.
