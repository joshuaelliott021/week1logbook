public class Module {
    
// Attributes
    private String moduleName;
    private String moduleCode;

// Constructor
    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

// Getters
    public String getModuleName() {
        return moduleName;
    }
        
    public String getModuleCode() {
        return moduleCode;
    }

    public Grade convertToGrade(int mark) {
        if (mark >= 85) {
            return Grade.A;
        } else if (mark >= 70) {
            return Grade.B;
        } else if (mark >= 55) {
            return Grade.C;
        } else if (mark >= 40) {
            return Grade.D;
        } else {
            return Grade.F;

        }
    }
}

