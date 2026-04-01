# SRM Semester 3 — 100 Coding Hours Practice

**Language:** Java &nbsp;|&nbsp; **Curriculum:** CSE Cybersecurity &nbsp;|&nbsp; **Status:** Active

---

## Overview

This repository contains Java implementations of programming problems and real-world applications developed during SRM Semester 3 coding practice sessions. Solutions demonstrate proficiency in data structures, algorithms, object-oriented design, and problem-solving.

---

## Project Structure

```
SRM-STEP-100-CodIn-Hours-Practice/
│
├── Year2/                              # All Year 2 solutions
│   │
│   ├── PalindromeCheckerApp/           # Palindrome checking (UC1-UC5)
│   │   ├── UC1_EntryWelcome.java
│   │   ├── UC2_HardcodedPalindromeChecker.java
│   │   ├── UC3_StringReversePalindromeChecker.java
│   │   ├── UC4_CharArrayPalindromeChecker.java
│   │   └── UC5_StackPalindromeChecker.java
│   │
│   ├── QueueStackPalindromeCheck/      # Queue & Stack solutions (UC6-UC13)
│   │   ├── UseCase6PalindromeCheckerApp.java
│   │   ├── UseCase7PalindromeCheckerApp.java
│   │   ├── UseCase8PalindromeCheckerApp.java
│   │   ├── UseCase9PalindromeCheckerApp.java
│   │   ├── UseCase10PalindromeCheckerApp.java
│   │   ├── UseCase11PalindromeCheckerApp.java
│   │   ├── UseCase12PalindromeCheckerApp.java
│   │   └── UseCase13PalindromeCheckerApp.java
│   │
│   ├── SortingSearching/               # Sorting & Searching algorithms
│   │   ├── AccountIdLookup.java
│   │   ├── ClientRiskRanker.java
│   │   ├── PortfolioReturnSorter.java
│   │   ├── RiskThresholdLookup.java
│   │   ├── TradeVolumeSorter.java
│   │   └── TransactionFeeSorter.java
│   │
│   ├── BookMyStayApp/                  # Hotel Booking Management System
│   │   ├── UseCase1HotelBookingApp.java
│   │   ├── UseCase2BasicRoomTypes.java
│   │   ├── UseCase3CentralizedInventory.java
│   │   ├── UseCase4RoomSearchAvailability.java
│   │   ├── UseCase5BookingRequestQueue.java
│   │   ├── UseCase6RoomAllocation.java
│   │   ├── UseCase7AddOnServiceSelection.java
│   │   ├── UseCase8BookingHistoryReport.java
│   │   ├── UseCase9ErrorHandlingValidation.java
│   │   ├── UseCase10BookingCancellation.java
│   │   ├── UseCase11ConcurrentBookingSimulation.java
│   │   └── UseCase12DataPersistenceRecovery.java
│   │
│   ├── ExercismSolutions/              # Additional practice solutions
│   │
│   └── [Core Data Structure Files]     # Individual implementations
│       ├── AnalyticsDashboard.java
│       ├── AutocompleteSystem.java
│       ├── BookingHistory.java
│       ├── BookingReportService.java
│       ├── DNSCache.java
│       ├── FlashSaleInventoryManager.java
│       ├── InventoryManager.java
│       ├── MultiLevelCache.java
│       ├── ParkingLot.java
│       ├── PlagiarismDetector.java
│       ├── RateLimiter.java
│       ├── Reservation.java
│       ├── SocialMedia.java
│       ├── TransactionAnalyzer.java
│       ├── UseCase1HotelBookingApp.java
│       ├── UseCase8BookingHistoryReport.java
│       └── UsernameAvailabilityChecker.java
│
└── README.md
```

---

## Year 2 Solutions

### Palindrome Checker App (UC1-UC5)

| Use Case | Description | Key Concept |
|----------|-------------|-------------|
| UC1 | Application Entry & Welcome | Basic I/O, main method |
| UC2 | Hardcoded Palindrome Checker | String comparison |
| UC3 | String Reverse Checker | Loop-based reversal |
| UC4 | Character Array Checker | Two-pointer technique |
| UC5 | Stack-Based Checker | LIFO data structure |

### Queue & Stack Palindrome Check (UC6-UC13)

| Use Case | Description | Data Structure |
|----------|-------------|----------------|
| UC6 | Queue + Stack Fairness Check | Queue + Stack |
| UC7 | Deque Based Optimized Checker | Double-ended Queue |
| UC8 | Linked List Based Checker | LinkedList |
| UC9 | Recursive Checker | Recursion |
| UC10 | Normalized Validation | String preprocessing |
| UC11 | Object-Oriented Service | Design Patterns |
| UC12 | Strategy Pattern | Algorithm interchangeability |
| UC13 | Performance Comparison | Benchmarking |

### Sorting & Searching

| Problem | Description | Technique |
|---------|-------------|-----------|
| AccountIdLookup | Find account IDs in logs | Linear & Binary Search |
| ClientRiskRanker | Rank clients by risk score | Bubble & Insertion Sort |
| TradeVolumeSorter | Sort trade volumes | Merge & Quick Sort |
| PortfolioReturnSorter | Sort by return rate | Stable sorting |
| TransactionFeeSorter | Sort fees for audit | Batch sorting |
| RiskThresholdLookup | Binary threshold search | Floor/Ceiling functions |

### Core Data Structures

- **AnalyticsDashboard** — Real-time analytics with concurrent updates
- **AutocompleteSystem** — Trie-based search suggestions
- **BookingHistory** — Reservation tracking system
- **DNSCache** — LRU cache with TTL support
- **FlashSaleInventoryManager** — Thread-safe inventory management
- **InventoryManager** — Lock-free concurrent inventory
- **MultiLevelCache** — L1/L2/L3 cache hierarchy
- **ParkingLot** — Hash table with linear probing
- **PlagiarismDetector** — N-gram based similarity detection
- **RateLimiter** — Token bucket rate limiting
- **SocialMedia** — Username availability checker
- **TransactionAnalyzer** — K-Sum and duplicate detection

---

## BookMyStayApp — Hotel Booking System

A complete hotel booking management system:

| Use Case | Feature | Description |
|----------|---------|-------------|
| UC1 | Application Entry | Welcome message and initialization |
| UC2 | Basic Room Types | Room categorization |
| UC3 | Centralized Inventory | Room inventory management |
| UC4 | Room Search Availability | Search and filter rooms |
| UC5 | Booking Request Queue | Queue-based booking system |
| UC6 | Room Allocation | Room assignment logic |
| UC7 | Add-On Service Selection | Additional services |
| UC8 | Booking History Report | Transaction history |
| UC9 | Error Handling & Validation | Input validation |
| UC10 | Booking Cancellation | Cancellation processing |
| UC11 | Concurrent Booking Simulation | Multi-threaded booking |
| UC12 | Data Persistence & Recovery | File-based storage |

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Git for version control

### Installation

```bash
# Clone the repository
git clone https://github.com/harinish45/SRM-STEP-100-CodIn-Hours-Practice.git

# Navigate to project directory
cd SRM-STEP-100-CodIn-Hours-Practice
```

### Running Solutions

```bash
# Compile and run Palindrome Checker
javac Year2/PalindromeCheckerApp/UC1_EntryWelcome.java
java Year2.PalindromeCheckerApp.UC1_EntryWelcome

# Run Hotel Booking App
javac Year2/BookMyStayApp/UseCase1HotelBookingApp.java
java Year2.BookMyStayApp.UseCase1HotelBookingApp

# Run Sorting Algorithms
javac Year2/SortingSearching/TradeVolumeSorter.java
java Year2.SortingSearching.TradeVolumeSorter
```

---

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/AmazingFeature`
3. Commit changes: `git commit -m 'Add AmazingFeature'`
4. Push to branch: `git push origin feature/AmazingFeature`
5. Open a Pull Request

---

## License

This project is licensed under the MIT License.

---

## Author

**Harinish S V**

- GitHub: [@harinish45](https://github.com/harinish45)

---

*Last updated: April 2026*