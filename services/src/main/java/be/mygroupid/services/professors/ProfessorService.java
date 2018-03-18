package be.mygroupid.services.professors;

import be.mygroupid.domain.professors.Professor;
import be.mygroupid.domain.professors.ProfessorRepository;
import be.mygroupid.services.exceptions.IllegalFieldFoundException;
import be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction;
import be.mygroupid.services.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction.CREATE;
import static be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction.UPDATE;

//copied code from example exercise switchfully

@Named
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessors() {
        return professorRepository.getProfessors();
    }

    public Professor getProfessor(Integer id) {
        assertProfessorIsPresent(professorRepository.getProfessor(id));
        return professorRepository.getProfessor(id);
    }

    public Professor createProfessor(Professor professor) {
        assertProfessorIdIsNotPresent(professor, CREATE);
        return professorRepository.storeProfessor(professor);
    }

    public Professor updateProfessor(Integer id, Professor updatedProfessor) {
        assertProfessorIdIsNotPresent(updatedProfessor, UPDATE);
        assertProfessorIsPresent(professorRepository.getProfessor(id));
        updatedProfessor.setId(id);
        return professorRepository.updateProfessor(updatedProfessor);
    }

    public void deleteProfessor(Integer id) {
        assertProfessorIsPresent(professorRepository.getProfessor(id));
        professorRepository.deleteProfessor(id);
    }

    public void assertProfessorIsPresent(Professor professor) {
        if (professor == null) {
            throw new UnknownResourceException("ID", Professor.class.getSimpleName());
        }
    }

    private void assertProfessorIdIsNotPresent(Professor providedProfessor, CrudAction action) {
        if (providedProfessor.getId() != null) {
            throw new IllegalFieldFoundException("ID", Professor.class.getSimpleName(), action);
        }
    }

}
