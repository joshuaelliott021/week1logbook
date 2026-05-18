public class Module {
    private String code;
    private String title;
    private int credits;

    public Module(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

       public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + "credits)";
    }
    
}
