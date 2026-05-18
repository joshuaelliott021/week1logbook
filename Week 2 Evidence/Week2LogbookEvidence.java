import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Week2LogbookEvidence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task 1: Age check (extended from Week 1 Task 6)");

        int birthYear = getValidInt(scanner, "Enter your birth year (e.g. 2003): ");
        int birthMonth = getValidIntRange(scanner, "Enter your birth month (1-12): ", 1, 12);
        int birthDay = getValidIntRange(scanner, "Enter your birth day (1-31): ", 1, 31);

        LocalDate dob;
        try {
            dob = LocalDate.of(birthYear, birthMonth, birthDay);
        } catch (Exception e) {
            System.out.println("Invalid date entered. Please restart the program and try again.");
            return;
        }

        LocalDate today = LocalDate.now();
        Period age = Period.between(dob, today);
        int yearsOld = age.getYears();

        System.out.println("You are " + yearsOld + " years old.");

        if (yearsOld >= 18) {
            System.out.println("You are 18 or older.");
        } else {
            System.out.println("You are under 18.");
        }

        // --------------------------------------------------------------------
        // Task 2: Grade conversion for university undergraduate classification

        System.out.println("\nTask 2: Grade conversion for university undergraduate classification");

        char grade = getValidGrade(scanner, "Enter your grade (A - F): ");

        String classification;

        switch (grade) {
            case 'A':
                classification = "First Class";
                break;
            case 'B':
                classification = "Upper Second Class (2:1)";
                break;
            case 'C':
                classification = "Lower Second Class (2:2)";
                break;
            case 'D':
                classification = "Third Class";
                break;
            case 'F':
                classification = "Fail";
                break;
            default:
                classification = "Invalid grade";
        }

        System.out.println("Classification: " + classification);

        // --------------------------------------------------------------------
        // Task 3: Output the digits between 0 and 9 using a loop

        System.out.println("\nTask 3: Digits from 0 to 9");

        for (int i = 0; i <= 9; i++) {
            System.out.println(i);
        }

        // --------------------------------------------------------------------
        // Task 4: Seven times multiplication table

        System.out.println("\nTask 4: Seven Times Multiplication Table");

        for (int x = 1; x <= 12; x++) {
            System.out.println(x + " x 7 = " + (x * 7));
        }

        // --------------------------------------------------------------------
        // Task 5 & 6: User chooses multiplication table + restart option

        String again;

        do {
            System.out.println("\nTask 5 & 6: Choose a multiplication table");

            int tableNumber = getValidIntRange(scanner, "Enter a number for the times table (1-12): ", 1, 12);

            System.out.println("\n" + tableNumber + " Times Table:");

            for (int n = 1; n <= 12; n++) {
                System.out.println(n + " x " + tableNumber + " = " + (n * tableNumber));
            }

            System.out.print("\nWould you like to choose another times table? (yes/no): ");
            again = scanner.next().trim().toLowerCase();

        } while (again.equals("yes"));

        System.out.println("\nGoodbye! Thanks for using the program.");

        // --------------------------------------------------------------------
        // Task 7: Exam mark to grade conversion

        System.out.println("\nTask 7: Exam Mark to Grade Converter");

        int mark = getValidIntRange(scanner, "Enter your exam mark (0-100): ", 0, 100);

        String examGrade;

        if (mark >= 70) {
            examGrade = "A (First Class)";
        } else if (mark >= 60) {
            examGrade = "B (Upper Second Class - 2:1)";
        } else if (mark >= 50) {
            examGrade = "C (Lower Second Class - 2:2)";
        } else if (mark >= 40) {
            examGrade = "D (Third Class)";
        } else {
            examGrade = "F (Fail)";
        }

        System.out.println("Your grade is: " + examGrade);

// Print only even numbers from a loop that repeats 10 times
        System.out.println("\nTask 8: Print only even numbers from a loop that repeats 10 times");

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    // ------------------ INPUT VALIDATION METHODS ------------------

    public static int getValidInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public static int getValidIntRange(Scanner scanner, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Error: Please enter a value between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    // Grade validation method
    public static char getValidGrade(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().trim().toUpperCase();

            if (input.length() == 1) {
                char grade = input.charAt(0);

                if (grade == 'A' || grade == 'B' || grade == 'C' ||
                    grade == 'D' || grade == 'F') {
                    return grade;
                }
            }

            System.out.println("Invalid input. Please enter a grade between A and F.");
        }
    }
}