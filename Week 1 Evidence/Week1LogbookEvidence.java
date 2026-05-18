import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Week1LogbookEvidence {
    // print hello world statement and ask user for their name and greet them
    public static void main(String[] args) {
        System.out.println("Hello, Examiner!");
        System.out.println("This is my Java logbook evidence");

  
    Scanner scanner = new Scanner(System.in);
        System.out.println("This section is to greet you and ask for your name.");
        System.out.print("Please enter your name: ");
    String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to my logbook evidence.");

    // ask user for 2 lengths of a rectangle and calculate the area
        System.out.println("This section is to calculate the area of a rectangle.");
        System.out.print("Please enter the length of the rectangle: "); 
    double length = scanner.nextDouble();
        System.out.println("please enter the width of the rectangle: ");
    double width = scanner.nextDouble();
    double area = length * width;
        System.out.println("The area of the rectangle is: " + area + " cm²");

    // ask user for 2 numbers and calculate the average, then print the result
        System.out.println("This section is to calculate the average of two numbers.");
        System.out.print("Please enter the first number: ");
    double num1 = scanner.nextDouble();
        System.out.print("Please enter the second number: ");
    double num2 = scanner.nextDouble();
    double average = (num1 + num2) / 2;
        System.out.println("The average of the two numbers is: " + average);

    // ask user to input 5 integers, the program should print the numbers in the order they were entered, then print the numbers in reverse order
    int [] number = new int[5];
        System.out.println("This section is to process the order of the integers and then reverse the order of the integers.");
        System.out.println("Please enter 5 integers which are separated by a single space: ");
        for (int i = 0; i < number.length; i++) {
            number [i] = scanner.nextInt();
        }
        System.out.println("The numbers in the order they were entered are: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println("\nThe numbers in reverse order are: ");
        for (int i = number.length - 1; i >= 0; i--) {
            System.out.print(number[i] + " ");
        }

    // ask user to input their age, then calculate their date of birth and print it
        System.out.println("This section is to calculate your year of birth based on your age");

        System.out.print("Enter your birth year (e.g. 2003): ");
        int birthYear = scanner.nextInt();

        System.out.print("Enter your birth month (1-12): ");
        int birthMonth = scanner.nextInt();

        System.out.print("Enter your birth day (1-31): ");
        int birthDay = scanner.nextInt();

        LocalDate dob = LocalDate.of(birthYear, birthMonth, birthDay);

        LocalDate today = LocalDate.now();

        Period age = Period.between(dob, today);
        int yearsOld = age.getYears();

        System.out.println("You are " + yearsOld + " years old.");

    // calculate age in days after the last process
     
    long ageInDays = age.toTotalMonths() * 30 + age.getDays();
        System.out.println("You are approximately " + ageInDays + " days old.");

    // convert feet to miles (5280 feet in a mile)
        System.out.println("This section is to convert feet to miles.");
        System.out.print("Please enter the number of feet: ");
    double feet = scanner.nextDouble();
    double miles = feet / 5280;
        System.out.println("The number of miles is: " + miles);

    }
  }
