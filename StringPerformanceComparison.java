public class StringPerformanceComparison {
public static void main(String[] args) {
// TODO: Implement performance tests for different approaches
// Test 1: String concatenation performance
System.out.println("=== PERFORMANCE COMPARISON ===");
// TODO: Test string concatenation with regular String (slow
method)
long startTime = System.nanoTime();
String result1 = concatenateWithString(1000);
long endTime = System.nanoTime();
System.out.println("String concatenation time: " + (endTime -
startTime) + " ns");
// TODO: Test string concatenation with StringBuilder (fast method)
// TODO: Test string concatenation with StringBuffer (thread-safe
method)
// TODO: Compare memory usage (approximate)
// TODO: Demonstrate thread safety differences
// TODO: Create practical examples showing when to use each
approach
}
// TODO: Method using String concatenation (inefficient)
public static String concatenateWithString(int iterations) {
String result = "";
for (int i = 0; i < iterations; i++) {
result += "Java " + i + " ";
}

5

return result;
}
// TODO: Method using StringBuilder (efficient, not thread-safe)
public static String concatenateWithStringBuilder(int iterations) {
// Your code here
}
// TODO: Method using StringBuffer (efficient, thread-safe)
public static String concatenateWithStringBuffer(int iterations) {
// Your code here
}
// TODO: Method to demonstrate StringBuilder methods
public static void demonstrateStringBuilderMethods() {
StringBuilder sb = new StringBuilder("Hello World");
// TODO: Use the following StringBuilder methods:
// 1. append() - Add text to end
// 2. insert() - Insert text at specific position
// 3. delete() - Remove characters from range
// 4. deleteCharAt() - Remove character at index
// 5. reverse() - Reverse the string
// 6. replace() - Replace substring
// 7. setCharAt() - Change character at index
// 8. capacity() - Show current capacity
// 9. ensureCapacity() - Set minimum capacity
// 10. trimToSize() - Reduce capacity to current length
// Your code here
}
// TODO: Method to demonstrate StringBuffer thread safety
public static void demonstrateThreadSafety() {
// Create multiple threads that modify the same StringBuffer
// Show that StringBuffer is thread-safe while StringBuilder is not
// Your code here
}
// TODO: Method to compare string comparison methods

6

public static void compareStringComparisonMethods() {
String str1 = "Hello";
String str2 = "Hello";
String str3 = new String("Hello");
// TODO: Compare using:
// 1. == operator (reference comparison)
// 2. equals() method (content comparison)
// 3. equalsIgnoreCase() method
// 4. compareTo() method (lexicographic comparison)
// 5. compareToIgnoreCase() method
// TODO: Explain the differences and when to use each
// Your code here
}
// TODO: Method to demonstrate memory efficiency
public static void demonstrateMemoryEfficiency() {
// TODO: Show memory usage before and after different string
operations
// TODO: Demonstrate string pool behavior
// TODO: Show StringBuilder capacity management
// Your code here
}
}