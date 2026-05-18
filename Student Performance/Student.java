import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private Map<String, Integer> moduleMarks; // key = moduleCode

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.moduleMarks = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    
    }

    public void setName(String name) {
    this.name = name;
    }


    public void addOrUpdateMark(Module module, int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100");
        }
        moduleMarks.put(module.getCode(), mark);
    }

    public Integer getMark(Module module) {
        return moduleMarks.get(module.getCode());
    }

    public Grade getGradeFor(Module module, GradingScheme scheme) {
        Integer mark = getMark(module);
        if (mark == null) 
            return null; // No mark recorded for this module
            return scheme.getGradeForMark(mark);
        
    }

    public Map<String, Integer> getAllMarks() {
        return moduleMarks;
    }

    private Map<String, Integer> marks = new HashMap<>();

    public void setMark(String moduleCode, int mark) {
        marks.put(moduleCode, mark);
    }

    public boolean hasMarks(String moduleCode) {
        return marks.containsKey(moduleCode);
    }

    public int getMark(String moduleCode) {
        return marks.getOrDefault(moduleCode, -1); // Return -1 if no mark is found
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

   @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name;
    }

}
