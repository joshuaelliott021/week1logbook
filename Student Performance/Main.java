import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    private static StudentRepository studentRepo = new StudentRepository();
    private static ModuleRepository moduleRepo = new ModuleRepository();
    private static GradingScheme grandingScheme = new GradingScheme();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        loadData(studentRepo, moduleRepo);

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manageStudents(scanner);
                    break;
                case "2":
                    manageModules(scanner);
                    break;
                case "3":
                    manageMarks(scanner);
                    break;
                case "4":
                    showReports(scanner);
                    break;
                case "5":
                    saveDataToFile();
                    break;
                case "6":
                    System.out.println(RED + "Exiting system... Goodbye!" + RESET);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void printMenuHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "==============================");
        System.out.println(PURPLE + "         " + title + RESET);
        System.out.println(CYAN + "==============================");
    }

    private static void printMainMenu() {
        printMenuHeader("Main Menu");
        System.out.println("Student Marks Management System");
        System.out.println("==============================");
        System.out.println(BLUE + "1." + RESET + BLUE + " Manage Students" + RESET);
        System.out.println(GREEN + "2." + RESET + GREEN + " Manage Modules" + RESET);
        System.out.println(YELLOW + "3." + RESET + YELLOW + " Input / Update Marks" + RESET);
        System.out.println(BLUE + "4." + RESET + BLUE + " Show Reports" + RESET);
        System.out.println(GREEN + "5." + RESET + GREEN + " Save Data to File" + RESET);
        System.out.println(YELLOW + "6." + RESET + YELLOW + " Exit" + RESET);
        
        System.out.print("Enter your choice: ");
    
    }

    private static void manageStudents(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println(CYAN + "\n--- Manage Students ---" + RESET);
            System.out.println(BLUE + "1." + RESET + BLUE + " Add Student" + RESET);
            System.out.println(GREEN + "2." + RESET + GREEN + " Remove Student" + RESET);
            System.out.println(YELLOW + "3." + RESET + YELLOW + " Edit Student" + RESET);
            System.out.println(BLUE + "4." + RESET + BLUE + " View All Students" + RESET);
            System.out.println(GREEN + "5." + RESET + GREEN + " Back to Main Menu" + RESET);

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner);
                    // Code to add student
                    break;
                case "2":
                    removeStudent(scanner);
                    // Code to remove student
                    break;
                case "3":
                    editStudent(scanner);
                    // Code to edit student
                    break;
                case "4":
                    listStudents();
                    // Code to view all students
                    break;
                case "5":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
      
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (studentRepo.studentExists(id)) {
            System.out.println("A student with this ID already exists. \n");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);
        studentRepo.addStudent(student);
        
        System.out.println("Student added successfully! \n");
    }

    private static void removeStudent(Scanner scanner) {
        System.out.println("Enter student ID to remove: ");
        String id = scanner.nextLine();

        if (studentRepo.removeStudent(id)) {
            System.out.println("Student removed successfully! \n");
        } else {
            System.out.println("No student found with that ID. \n");
        }
    }

    private static void editStudent(Scanner scanner) {
    System.out.println("Enter student ID to edit: ");
    String id = scanner.nextLine();

    Student student = studentRepo.getStudentById(id);
    if (student == null) {
        System.out.println("No student found with that ID.\n");
        return;
    }

    System.out.println("Current name: " + student.getName());
    System.out.print("Enter new name (or press Enter to keep current): ");
    String newName = scanner.nextLine();

    if (!newName.trim().isEmpty()) {
        student.setName(newName);
        System.out.println("Student updated successfully!\n");
    } else {
        System.out.println("No changes made.\n");
    }
}

    private static void listStudents() {
        System.out.println("\n--- List of Students ---");

        if (studentRepo.getAllStudents().isEmpty()) {
            System.out.println("No students found. \n");
            return;
        }

        for (Student student : studentRepo.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static void manageModules(Scanner scanner) {
        boolean back = false;

        while (!back) {
        System.out.println(CYAN + "\n--- Manage Modules ---" + RESET);
        System.out.println(BLUE + "1." + RESET + BLUE + " Add Module" + RESET);
        System.out.println(GREEN + "2." + RESET + GREEN + " Remove Module" + RESET);
        System.out.println(YELLOW + "3." + RESET + YELLOW + " Edit Module" + RESET);
        System.out.println(BLUE + "4." + RESET + BLUE + " View All Modules" + RESET);
        System.out.println(GREEN + "5." + RESET + GREEN + " Back to Main Menu" + RESET);

        System.out.println("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                addModule(scanner);
                break;
            case "2":
                removeModule(scanner);
                break;
            case "3":
                editModule(scanner);
                break;
            case "4":
                listModules();
                break;
            case "5":
                back = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
      }

    }

    private static void addModule(Scanner scanner) {
        System.out.println("Enter module code: ");
        String code = scanner.nextLine();

        if (moduleRepo.moduleExists(code)) {
            System.out.println("A module with this code already exists. \n");
            return;
        
        }

        System.out.println("Enter module name: ");
        String name = scanner.nextLine();

        System.out.println("Enter module credits: ");
        int credits = Integer.parseInt(scanner.nextLine());

        Module module = new Module(code, name, credits);
        moduleRepo.addModule(module);

        System.out.println("Module added successfully! \n");
    }

    private static void removeModule(Scanner scanner) {
        System.out.println("Enter module code to remove: ");
        String code = scanner.nextLine();

        if (moduleRepo.removeModule(code)) {
            System.out.println("Module removed successfully! \n");
        } else {
            System.out.println("No module found with that code. \n");
        }

    } 

    private static void editModule(Scanner scanner) {
        System.out.println("Enter module code to edit: ");
        String code = scanner.nextLine();

        Module module = moduleRepo.getModuleByCode(code);
        if (module == null) {
            System.out.println("No module found with that code. \n");
            return;
        }

        System.out.println("Current name: " + module.getTitle());
        System.out.println("Enter new name (or press Enter to keep current): ");
        String newName = scanner.nextLine();

        if (!newName.trim().isEmpty()) {
            module.setTitle(newName);
            System.out.println("Module updated successfully! \n");
        } else {
            System.out.println("No changes made. \n");
        }
    }
    
    private static void listModules() {
        System.out.println("\n--- List of Modules ---");

        if (moduleRepo.getAllModules().isEmpty()) {
            System.out.println("No modules found. \n");
            return;
        }

        for (Module module : moduleRepo.getAllModules()) {
            System.out.println(module);
        }
        System.out.println();
    }

    private static void manageMarks(Scanner scanner) {
        System.out.println(CYAN + "\n--- Input / Update Marks ---" + RESET);
        System.out.println(BLUE + "1." + RESET + BLUE + " Input Mark" + RESET);
        System.out.println(GREEN + "2." + RESET + GREEN + " Update Mark" + RESET);
        System.out.println(YELLOW + "3." + RESET + YELLOW + " Back to Main Menu" + RESET);

        System.out.println("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                inputMark(scanner);
                break;
            case "2":
                updateMark(scanner);
                break;
            case "3":
                // Back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void inputMark(Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = studentRepo.getStudentById(studentId);
        if (student == null) {
            System.out.println("No student found with that ID. \n");
            return;
        }

        System.out.println("Enter module code: ");
        String moduleCode = scanner.nextLine();

        Module module = moduleRepo.getModuleByCode(moduleCode);
        if (module == null) {
            System.out.println("No module found with that code. \n");
            return;
        }

        System.out.println("Enter mark (0-100): ");
        int mark;
        try {
            mark = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark. Please enter a number between 0 and 100. \n");
            return;
        }

        if (mark < 0 || mark > 100) {
            System.out.println("Mark must be between 0 and 100. \n");
            return;
        }

        student.setMark(moduleCode, mark);
        System.out.println("Mark recorded successfully! \n");
    }

    private static void updateMark(Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = studentRepo.getStudentById(studentId);
        if (student == null) {
            System.out.println("No student found with that ID. \n");
            return;
        }

        System.out.print("Enter module code: ");
        String moduleCode = scanner.nextLine();

        Module module = moduleRepo.getModuleByCode(moduleCode);
        if (module == null) {
            System.out.println("No module found with that code. \n");
            return;
        }

        if (!student.hasMarks(moduleCode)) {
            System.out.println("No existing mark found for this student and module. Please input a mark first. \n");
            return;
        }

        System.out.println("Current mark: " + student.getMark(moduleCode));
        System.out.println("Enter new mark (0-100): ");
        int newMark;

        try {
            newMark = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark. Please enter a number between 0 and 100. \n");
            return;
        }

        if (newMark < 0 || newMark > 100) {
            System.out.println("Mark must be between 0 and 100. \n");
            return;
        }

        student.setMark(moduleCode, newMark);
        System.out.println("Mark updated successfully! \n");

    }

    private static void showReports(Scanner scanner) {
        boolean back = false;

    while (!back) {
        System.out.println(CYAN + "\n--- Show Reports ---" + RESET);
        System.out.println(BLUE + "1." + RESET + BLUE + " Show Student Grades" + RESET);
        System.out.println(GREEN + "2." + RESET + GREEN + " Module Statistics (mean/min/max)" + RESET);
        System.out.println(YELLOW + "3." + RESET + YELLOW + " Module Grade Profile" + RESET);
        System.out.println(BLUE + "4." + RESET + BLUE + " Back to Main Menu" + RESET);

        System.out.println("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                showStudentGrades(scanner);
                break;
            case "2":
                showModuleStats(scanner);
                break;
            case "3":
                showModuleGradeProfile(scanner);
                break;
            case "4":
                back = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
        
    } 

    private static void showStudentGrades(Scanner scanner) {
    System.out.print("Enter student ID: ");
    String studentId = scanner.nextLine();

    Student student = studentRepo.getStudentById(studentId);
    if (student == null) {
        System.out.println("No student found with that ID.\n");
        return;
    }

    System.out.println("\nGrades for " + student.getName() + " (ID: " + student.getId() + "):");

    if (student.getAllMarks().isEmpty()) {
        System.out.println("No marks recorded for this student.\n");
        return;
    }

    for (String moduleCode : student.getAllMarks().keySet()) {
        int mark = student.getMark(moduleCode);
        String grade = grandingScheme.getGradeForMark(mark).toString();

        Module module = moduleRepo.getModuleByCode(moduleCode);
        String moduleTitle = (module != null) ? module.getTitle() : "Unknown Module";

        System.out.println(moduleCode + " - " + moduleTitle + ": Mark = " + mark + ", Grade = " + grade);
    }

    System.out.println();
}

    private static void showModuleStats(Scanner scanner) {
        System.out.print("Enter module code: ");
        String moduleCode = scanner.nextLine();

        Module module = moduleRepo.getModuleByCode(moduleCode);
        if (module == null) {
            System.out.println("No module found with that code.\n");
            return;
        }

        int totalMarks = 0;
        int count = 0;
        int minMark = Integer.MAX_VALUE;
        int maxMark = Integer.MIN_VALUE;

        for (Student student : studentRepo.getAllStudents()) {
            if (student.hasMarks(moduleCode)) {
                int mark = student.getMark(moduleCode);
                totalMarks += mark;
                count++;
                minMark = Math.min(minMark, mark);
                maxMark = Math.max(maxMark, mark);
            }
        }

        if (count == 0) {
            System.out.println("No marks recorded for this module.\n");
            return;
        }

        double meanMark = (double) totalMarks / count;

        System.out.println("\nStatistics for " + module.getTitle() + " (" + module.getCode() + "):");
        System.out.println("Mean Mark: " + String.format("%.2f", meanMark));
        System.out.println("Minimum Mark: " + minMark);
        System.out.println("Maximum Mark: " + maxMark);
        System.out.println();
    }

    private static void showModuleGradeProfile(Scanner scanner) {
    System.out.print("Enter module code: ");
    String moduleCode = scanner.nextLine();

    Module module = moduleRepo.getModuleByCode(moduleCode);
    if (module == null) {
        System.out.println("No module found with that code.\n");
        return;
    }

    Map<Grade, Integer> gradeDistribution = new HashMap<>();

    // Initialize grade distribution
    for (Grade grade : Grade.values()) {
        gradeDistribution.put(grade, 0);
    }

    for (Student student : studentRepo.getAllStudents()) {
        if (student.hasMarks(moduleCode)) {
            int mark = student.getMark(moduleCode);
            Grade grade = grandingScheme.getGradeForMark(mark);
            gradeDistribution.put(grade, gradeDistribution.get(grade) + 1);
        }
    }

    System.out.println("\nGrade Profile for " + module.getTitle() + " (" + module.getCode() + "):");

    }

    private static void saveDataToFile() {
        try (FileWriter writer = new FileWriter("student_data.txt")) {
            writer.write("Students:\n");
            for (Student student : studentRepo.getAllStudents()) {
                writer.write(student.toString() + "\n");
            }

            writer.write("\nModules:\n");
            for (Module module : moduleRepo.getAllModules()) {
                writer.write(module.toString() + "\n");
            }

            System.out.println("Data saved to student_data.txt successfully!\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage() + "\n");
        }
    }

    public static void loadData(StudentRepository studentRepo, ModuleRepository moduleRepo) {
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {

        String line;
        while ((line = reader.readLine()) != null) {

            String[] parts = line.split("\\|");

            switch (parts[0]) {
                case "STUDENT":
                    String studentId = parts[1];
                    String studentName = parts[2];
                    studentRepo.addStudent(new Student(studentId, studentName));
                    break;
              
                case "MODULE":
                    String moduleCode = parts[1];
                    String moduleTitle = parts[2];
                    int credits = Integer.parseInt(parts[3]);
                    moduleRepo.addModule(new Module(moduleCode, moduleTitle, credits));
                    break;

                case "MARK":
                    String markStudentId = parts[1];
                    String markModuleCode = parts[2];
                    int markValue = Integer.parseInt(parts[3]);

                    Student s = studentRepo.getStudentById(markStudentId);
                    if (s != null) {
                        s.setMark(markModuleCode, markValue);
                    }
                    break;

                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while loading data: " + e.getMessage() + "\n");
        }

    }

}