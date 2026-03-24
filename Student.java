public class Student {
    
    int studentID;
    String name;
    Course course; // NEW

    public Student(int studentID, String name, Course course) {
    this.studentID = studentID;
    this.name = name;
    this.course = course;
}

    public void print() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + name);

        if (course != null) {
            System.out.println("Enrolled Course: " + course.courseName);
        } else {
            System.out.println("No course enrolled.");
        }
    }
}
