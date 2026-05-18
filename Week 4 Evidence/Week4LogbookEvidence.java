import java.util.*;

public class Week4LogbookEvidence {

    public static void main(String[] args) {

        List<Student> students = List.of(
            new Student("Josh"),
            new Student("Ali"),
            new Student("Junaid")
        );

        List<Module> modules = List.of(
            new Module("Programming", "CS101"),
            new Module("Data Structures", "CS102"),
            new Module("Networks", "CS103"),
            new Module("Cyber Security", "CS104")
        );

        List<ModuleMark> moduleMarks = new ArrayList<>();
        Random rand = new Random();

        for (Student student : students) {
            for (Module module : modules) {
                int mark = rand.nextInt(101); // Random mark between 0 and 100
                moduleMarks.add(new ModuleMark(student, module, mark));
            }
        }

        for (ModuleMark mm : moduleMarks) {
            System.out.println(mm);
        }

        // Create course and student
        Course c1 = new Course("CS101", "Computer Science");
        Student s1 = new Student("Josh");

        int[] marks = s1.getMarks();

        System.out.println("Marks for " + s1.getStudentName() + ":");

        // Print module name, code, mark, and grade
        for (int i = 0; i < marks.length; i++) {
            Module m = c1.getModule(i);
            int mark = marks[i];
            Grade grade = m.convertToGrade(mark);

            System.out.println(
                m.getModuleName() + " (" + m.getModuleCode() + "): " 
                + mark + " - Grade: " + grade
            );
        }

        System.out.println();
        c1.printCourseDetails();

        Statistics.calculateStatistics(moduleMarks);
    }
}