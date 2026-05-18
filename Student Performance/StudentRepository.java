import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class StudentRepository {

    private Map<String, Student> students;
    
    public StudentRepository() {
        this.students = new HashMap<>();

    }

    public boolean addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            return false; // ID already exists
        }
        students.put(student.getId(), student);
        return true;
    }

    public boolean removeStudent(String id) {
        return students.remove(id) != null;
    }

    public Student getStudentById(String id) {
        return students.get(id);
    }

    public boolean studentExists(String id) {
        return students.containsKey(id);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

}
