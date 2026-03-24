public class Week3LogbookEvidence {
    public static void main(String[] args) {

        // --- Create courses FIRST ---
        Course c1 = new Course(987, "Computing");
        Course c2 = new Course(988, "Business Management");
        Course c3 = new Course(989, "Law");

        // Print courses to test
        c1.print();
        System.out.println();
        c2.print();
        System.out.println();
        c3.print();
        System.out.println();

        // --- Now create students and assign courses ---
        Student s1 = new Student(12345, "Josh", c1);
        Student s2 = new Student(12346, "Yusuf", c2);
        Student s3 = new Student(12347, "Junaid", c3);

        // Print students to test
        s1.print();
        System.out.println();
        s2.print();
        System.out.println();
        s3.print();
        System.out.println();

        // --- Task 10: Store students in an array ---
        Student[] students = { s1, s2, s3 };
        System.out.println("\n--- All Students ---");
        for (int i = 0; i < students.length; i++) {
            students[i].print();
            System.out.println();
        }

        // --- Task 11: Store courses in an array ---
        Course[] courses = { c1, c2, c3 };
        System.out.println("\n--- All Courses ---");
        for (int i = 0; i < courses.length; i++) {
            courses[i].print();
            System.out.println();
        }

        // --- Task 12: Link students to courses ---
        System.out.println("\n--- Student Enrolments ---");
        System.out.println("Student " + s1.name + " is enrolled on the course: " + s1.course.courseName);
        System.out.println("Student " + s2.name + " is enrolled on the course: " + s2.course.courseName);
        System.out.println("Student " + s3.name + " is enrolled on the course: " + s3.course.courseName);
    }
}