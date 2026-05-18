public class Student {

    private String studentName;
    private int[] marks; // Week 4 attribute

    public Student(String studentName) {
        this.studentName = studentName;

        // Create the array to store 4 marks
        marks = new int[4];

        // Assign random marks for each module
        for (int i = 0; i < marks.length; i++) {
            marks[i] = generateRandomMark();
        }
        
    }

    private int generateRandomMark() {
        return (int) (Math.random() * 101); // Generates a random mark between 0 and 100
    }

    public void setMark(int index, int value) {
        if (index >= 0 && index < 4 && value >= 0 && value <= 100) {
            marks[index] = value;
        } else {
            System.out.println("Invalid index or mark value.");
        }
    }

    public int[] getMarks() {
        return marks;
    }

    public String getStudentName() {
        return studentName;
    }
}