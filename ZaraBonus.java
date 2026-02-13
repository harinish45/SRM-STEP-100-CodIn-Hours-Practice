import java.util.*;

public class ZaraBonus {

    public static double[][] generateSalaryAndService() {
        double[][] data = new double[10][2]; // [salary, years of service]
        for (int i = 0; i < 10; i++) {
            int salary = (int)(Math.random() * 50000 + 10000); // 5-digit salary
            int years = (int)(Math.random() * 10 + 1); // 1 to 10 years
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[10][3]; // [oldSalary, bonus, newSalary]
        for (int i = 0; i < 10; i++) {
            double oldSalary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? (0.05 * oldSalary) : (0.02 * oldSalary);
            double newSalary = oldSalary + bonus;
            result[i][0] = oldSalary;
            result[i][1] = bonus;
            result[i][2] = newSalary;
        }
        return result;
    }

    public static void printSummary(double[][] data, double[][] result) {
        double totalOld = 0, totalBonus = 0, totalNew = 0;

        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", "ID", "OldSalary", "Years", "Bonus", "NewSalary", "BonusRate");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double oldSalary = result[i][0];
            double bonus = result[i][1];
            double newSalary = result[i][2];
            double years = data[i][1];
            double bonusRate = (years > 5) ? 5 : 2;

            totalOld += oldSalary;
            totalBonus += bonus;
            totalNew += newSalary;

            System.out.printf("%-5d %-10.2f %-10.0f %-10.2f %-10.2f %-10.0f%%\n", 
                (i + 1), oldSalary, years, bonus, newSalary, bonusRate);
        }

        System.out.println("\n------------------ Total Summary ------------------");
        System.out.printf("Total Old Salary : ₹%.2f\n", totalOld);
        System.out.printf("Total Bonus Paid : ₹%.2f\n", totalBonus);
        System.out.printf("Total New Salary : ₹%.2f\n", totalNew);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateSalaryAndService();
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        printSummary(employeeData, bonusData);
    }
}
