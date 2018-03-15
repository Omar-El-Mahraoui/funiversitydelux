package be.mygroupid.resources.professors;

import be.mygroupid.domain.professors.Professor;

import static be.mygroupid.domain.professors.Professor.ProfessorBuilder.professor;

// copied from example exercise
public class ProfessorMapper {

    ProfessorDto toDto(Professor professor) {
        return ProfessorDto.professorDto()
                .withId(professor.getId())
                .withFirstname(professor.getFirstname())
                .withLastname(professor.getLastname());
    }

    Professor toDomain(ProfessorDto professorDto) {
        return professor()
                .withId(professorDto.getId())
                .withFirstname(professorDto.getFirstname())
                .withLastname(professorDto.getLastname())
                .build();
    }

}
