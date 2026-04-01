# 🎓 SRM Semester 3 - 100 Coding Hours Practice

[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Active-green.svg)]()

> A comprehensive collection of Java solutions from SRM Semester 3 – 100 Coding Hours Practice, demonstrating problem-solving skills and core programming concepts aligned with the CSE Cybersecurity curriculum.

---

## 📚 Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Year 2 Solutions](#year-2-solutions)
  - [Palindrome Checker App](#palindrome-checker-app)
  - [Queue & Stack Palindrome Check](#queue--stack-palindrome-check)
  - [Sorting & Searching](#sorting--searching)
  - [Core Data Structures](#core-data-structures)
- [BookMyStayApp Solutions](#bookmystayapp-solutions)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

---

## 📖 Overview

This repository contains Java implementations of various programming problems and real-world applications developed during the SRM Semester 3 coding practice sessions. Each solution demonstrates proficiency in:

- 🔹 **Data Structures**: Arrays, Linked Lists, Stacks, Queues, Trees, Hash Maps
- 🔹 **Algorithms**: Sorting, Searching, Recursion, Dynamic Programming
- 🔹 **Object-Oriented Design**: Encapsulation, Inheritance, Polymorphism
- 🔹 **Problem Solving**: Logical thinking and algorithmic approach

---

## 📁 Project Structure

```
SRM-STEP-100-CodIn-Hours-Practice/
├── 📂 Year2/                          # Year 2 Advanced Solutions
│   ├── 🔤 PalindromeCheckerApp/       # Palindrome checking implementations
│   ├── 📊 QueueStackPalindromeCheck/  # Queue & Stack based solutions
│   ├── 🔍 SortingSearching/           # Sorting and searching algorithms
│   └── 🏗️ Core Data Structure Files    # Individual problem solutions
│
├── 📂 BookMyStayApp/                  # Hotel Booking System
│   ├── 🔤 PalindromeCheckerApp/
│   ├── 📊 QueueStackPalindromeCheck/
│   └── 🏨 UseCase Implementations/    # UC1 - UC12
│
├── 📂 ExercismSolutions/              # Additional practice solutions
│
└── 📄 README.md                       # This file
```

---

## 🎯 Year 2 Solutions

### 🔤 Palindrome Checker App

A comprehensive palindrome checking application with multiple implementation approaches:

| Use Case | Description | Algorithm |
|----------|-------------|-----------|
| UC1 | Application Entry & Welcome | Basic I/O |
| UC2 | Hardcoded Palindrome Checker | String comparison |
| UC3 | String Reverse Checker | Loop-based reversal |
| UC4 | Character Array Checker | Two-pointer technique |
| UC5 | Stack-Based Checker | LIFO data structure |

### 📊 Queue & Stack Palindrome Check

Advanced palindrome validation using various data structures:

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

### 🔍 Sorting & Searching

Efficient sorting and searching implementations:

| Problem | Description | Technique |
|---------|-------------|-----------|
| Account ID Lookup | Find account IDs in logs | Linear & Binary Search |
| Client Risk Ranker | Rank clients by risk score | Bubble & Insertion Sort |
| Trade Volume Sorter | Sort trade volumes | Merge & Quick Sort |
| Portfolio Return Sorter | Sort by return rate | Stable sorting |
| Transaction Fee Sorter | Sort fees for audit | Batch sorting |
| Risk Threshold Lookup | Binary threshold search | Floor/Ceiling functions |

### 🏗️ Core Data Structures

Individual implementations showcasing various concepts:

- **AnalyticsDashboard** - Real-time analytics with concurrent updates
- **AutocompleteSystem** - Trie-based search suggestions
- **BookingHistory** - Reservation tracking system
- **DNSCache** - LRU cache with TTL support
- **FlashSaleInventoryManager** - Thread-safe inventory management
- **InventoryManager** - Lock-free concurrent inventory
- **MultiLevelCache** - L1/L2/L3 cache hierarchy
- **ParkingLot** - Hash table with linear probing
- **PlagiarismDetector** - N-gram based similarity detection
- **RateLimiter** - Token bucket rate limiting
- **SocialMedia** - Username availability checker
- **TransactionAnalyzer** - K-Sum and duplicate detection

---

## 🏨 BookMyStayApp Solutions

A complete hotel booking management system with 12 use cases:

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

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 11 or higher
- **Git** for version control

### Installation

```bash
# Clone the repository
git clone https://github.com/harinish45/SRM-STEP-100-CodIn-Hours-Practice.git

# Navigate to the project directory
cd SRM-STEP-100-CodIn-Hours-Practice

# Compile and run any Java file
javac Year2/PalindromeCheckerApp/UC1_EntryWelcome.java
java Year2.PalindromeCheckerApp.UC1_EntryWelcome
```

### Running Specific Solutions

```bash
# Run Palindrome Checker
java Year2.PalindromeCheckerApp.UC3_StringReversePalindromeChecker

# Run Hotel Booking App
java BookMyStayApp.UseCase1HotelBookingApp

# Run Sorting Algorithms
java Year2.SortingSearching.TradeVolumeSorter
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Harinish S V**

[![GitHub](https://img.shields.io/badge/GitHub-harinish45-lightgrey?style=social&logo=github)](https://github.com/harinish45)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Harinish-blue?style=social&logo=linkedin)]()

---

## 📊 Project Statistics

[![Lines of Code](https://img.shields.io/tokei/lines/github/harinish45/SRM-STEP-100-CodIn-Hours-Practice)]()
[![Files](https://img.shields.io/github/directory-file-count/harinish45/SRM-STEP-100-CodIn-Hours-Practice)]()
[![Last Commit](https://img.shields.io/github/last-commit/harinish45/SRM-STEP-100-CodIn-Hours-Practice)]()

---

<div align="center">

**⭐ If you find this repository helpful, please give it a star!**

Made with ❤️ by Harinish S V

</div>