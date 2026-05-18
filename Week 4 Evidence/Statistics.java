import java.util.List;

public class Statistics {

    public static void calculateStatistics(List<ModuleMark> marks) {

        if (marks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }

        ModuleMark minMark = marks.get(0);
        ModuleMark maxMark = marks.get(0);
        int total = 0;

        for (ModuleMark mm : marks) {
            int mark = mm.getMark();
            total += mark;

            if (mark < minMark.getMark()) {
                minMark = mm;
            }

            if (mark > maxMark.getMark()) {
                maxMark = mm;
            }
        }

        double mean = (double) total / marks.size();

        System.out.println("\n=== Descriptive Statistics ===");

        System.out.println("Minimum Mark:");
        System.out.println(minMark.getStudent().getStudentName() + " - " +
                           minMark.getModule().getModuleName() + ": " +
                           minMark.getMark());

        System.out.println("\nMaximum Mark:");
        System.out.println(maxMark.getStudent().getStudentName() + " - " +
                           maxMark.getModule().getModuleName() + ": " +
                           maxMark.getMark());

        System.out.println("\nMean Mark:");
        System.out.printf("Average mark across all students/modules: %.2f%n", mean);
    }
}