public enum Grade {
    A("First Class"),
    B("Upper Second Class"),
    C("Lower Second Class"),
    D("Third Class"),
    F("Fail");

    private final String classification;

    Grade(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

}
