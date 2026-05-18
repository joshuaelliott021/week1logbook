public static void main(String[] args) {
    Module m = new Module("CS101", "Programming", 20);
    Student s = new Student("1001", "Josh Elliott");
    GradingScheme scheme = new GradingScheme();

    s.addOrUpdateMark(m, 85);

    System.out.println(s.getMark(m));
    System.out.println(s.getGradeFor(m, scheme));


}
