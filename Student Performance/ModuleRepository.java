import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class ModuleRepository {

    private Map<String, Module> modules;

    public ModuleRepository() {
        this.modules = new HashMap<>();

    }

    public boolean addModule(Module module) {
        if (modules.containsKey(module.getCode())) {
            return false; // module already exists
        }
        modules.put(module.getCode(), module);
        return true;
    }

    public boolean removeModule(String code) {
        return modules.remove(code) != null;
    }

    public Module getModuleByCode(String code) {
        return modules.get(code);
    }

    public boolean moduleExists(String code) {
        return modules.containsKey(code);
    }

    public Collection<Module> getAllModules() {
        return modules.values();
    }

}
