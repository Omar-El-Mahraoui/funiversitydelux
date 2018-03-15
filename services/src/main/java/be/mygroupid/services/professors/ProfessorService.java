package be.mygroupid.services.professors;

import be.mygroupid.domain.professors.Professor;
import be.mygroupid.domain.professors.ProfessorRepository;

import java.util.List;

//copied code from example exercise switchfully
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessors() {
        return professorRepository.getProfessors();
    }

}
