public class GradingScheme {

    public Grade getGradeForMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100");
        }

        if (mark >= 70) {
            return Grade.A;
        } else if (mark >= 60) {
            return Grade.B;
        } else if (mark >= 50) {
            return Grade.C;
        } else if (mark >= 40) {
            return Grade.D;
        } else {
            return Grade.F;
        }
    }

}
