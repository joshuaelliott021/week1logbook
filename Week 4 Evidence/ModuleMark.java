public class ModuleMark {
    
    private Student student;
    private Module module;
    private int mark;

    public ModuleMark(Student student, Module module, int mark) {
        this.student = student;
        this.module = module;
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public Module getModule() {
        return module;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return student.getStudentName() + " - " + module.getModuleName() + ": " + mark;
    }
}


