package com.employeewage;

import java.util.Random;

public class EmployeeWageMain{

    // Constants for default scenario
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Method to compute employee wage for a company
    public static int computeWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        int totalEmpHrs = 0, totalWorkingDays = 0;

        System.out.println("\n--- " + company + " Employee Wage Computation ---");
        
        while (totalEmpHrs < maxWorkingHours && totalWorkingDays < maxWorkingDays) {
            totalWorkingDays++;
            int empHrs = 0;

            int empCheck = new Random().nextInt(3); // 0, 1, 2
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }

            totalEmpHrs += empHrs;
            System.out.println("Day " + totalWorkingDays + ": Worked " + empHrs + " hrs");
        }

        int totalWage = totalEmpHrs * wagePerHour;
        System.out.println("Total Employee Wage for " + company + ": ₹" + totalWage);
        return totalWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        // UC1: Attendance Check
        int attendance = new Random().nextInt(2);
        System.out.println(attendance == 1 ? "Employee is Present" : "Employee is Absent");

        // UC2: Daily Wage
        int dailyWage = 20 * 8;
        System.out.println("Daily Wage (UC2): ₹" + dailyWage);

        // UC3: Part Time Wage
        int partTimeWage = 20 * 4;
        System.out.println("Part-Time Wage (UC3): ₹" + partTimeWage);

        // UC4: Switch Case Wage Calculation
        int empType = new Random().nextInt(3); // 0,1,2
        int empHrs = 0;
        switch (empType) {
            case IS_PART_TIME:
                empHrs = 4;
                System.out.println("Part-Time Employee (UC4)");
                break;
            case IS_FULL_TIME:
                empHrs = 8;
                System.out.println("Full-Time Employee (UC4)");
                break;
            default:
                System.out.println("Employee is Absent (UC4)");
        }
        System.out.println("Wage using Switch Case (UC4): ₹" + (empHrs * 20));

        // UC5: Monthly Wage (20 working days)
        int monthlyWage = 20 * 8 * 20;
        System.out.println("Monthly Wage for 20 Days (UC5): ₹" + monthlyWage);

        // UC6: Wage till Max 20 days or 100 hrs
        int maxDays = 20, maxHours = 100, totalHrs = 0, totalDays = 0;
        while (totalHrs < maxHours && totalDays < maxDays) {
            totalDays++;
            int dailyHrs = new Random().nextInt(3) == IS_FULL_TIME ? 8 :
                           new Random().nextInt(3) == IS_PART_TIME ? 4 : 0;
            totalHrs += dailyHrs;
        }
        int conditionalWage = totalHrs * 20;
        System.out.println("Wage till Max Hours/Days (UC6): ₹" + conditionalWage);

        // UC7 + UC8: Class method and compute wage for multiple companies
        computeWage("TCS", 25, 20, 100);
        computeWage("Infosys", 30, 22, 120);
        computeWage("Wipro", 28, 18, 90);
    }
}
