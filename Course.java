public class Course {
    
    int courseID;
    String courseName;

    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;

    }

    public void print() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
    }
}
