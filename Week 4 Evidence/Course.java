import java.util.ArrayList;

public class Course {
    
    private String CourseCode;
    private String courseName;
    private ArrayList<Module> modules;  // NEW WEEK 4 ATTRIBUTE

// Constructor

    public Course(String courseCode, String courseName) {
        this.CourseCode = courseCode;
        this.courseName = courseName;
        this.modules = new ArrayList<>(); // INITIALIZE THE MODULES LIST

// Add four module objects

        modules.add(new Module("Programming", "CS101"));
        modules.add(new Module("Web Development", "CS102"));
        modules.add(new Module("Databases", "CS103"));
        modules.add(new Module("Software Engineering", "CS104"));
    }

// Getter for modules

    public ArrayList<Module> getModules() {
        return modules;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public Module getModule(int index) {
        if (index >= 0 && index < modules.size()) {
            return modules.get(index);
        } else {
            System.out.println("Invalid module index.");
            return null;
        }
    }

    public void printCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Modules:");

        for (Module module : modules) {
            System.out.println("- " + module.getModuleName() + " (" + module.getModuleCode() + ")");
        
    }

   }
}
