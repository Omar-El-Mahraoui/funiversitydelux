package be.mygroupid.domain.professors;

import javax.inject.Named;
import java.util.*;

@Named
public class ProfessorRepository {

    private static Integer databaseIndex = 0;
    private Map<Integer, Professor> professors;

    public ProfessorRepository() {
        this.professors = new HashMap<Integer, Professor>();
        storeProfessor(new Professor("Albert1", "Einstein1"));
        storeProfessor(new Professor("Albert2", "Einstein1"));
        storeProfessor(new Professor("Albert3", "Einstein1"));
    }

    public Professor storeProfessor(Professor professor) {
        professor.setId(databaseIndex++);
        professors.put(professor.getId(), professor);
        return professor;
    }

    public List<Professor> getProfessors() {
        return Collections.unmodifiableList(new ArrayList<Professor>(professors.values()));
    }

    public Professor getProfessor(Integer id) {
        return professors.get(id);
    }

    public Professor updateProfessor(Professor professor) {
        professors.put(professor.getId(), professor);
        return professor;
    }

    public void deleteProfessor(Integer id) {
        professors.remove(id);
    }
}
