package be.mygroupid.resources.professors;


import be.mygroupid.domain.professors.Professor;
import be.mygroupid.services.professors.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// copied code from example
@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    private ProfessorService professorService;
    private ProfessorMapper professorMapper;

    @Inject
    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getProfessors() {
        return professorService.getProfessors().stream()
                .map(professorMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable("id") Integer id) {
        return professorMapper
                .toDto(professorService.getProfessor(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody ProfessorDto professorDto) {
        Professor professor = professorMapper.toDomain(professorDto);
        return professorMapper
                .toDto(professorService.createProfessor(professor));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto updateProfessor(@PathVariable Integer id, @RequestBody ProfessorDto professorDto) {
        Professor professor = professorMapper.toDomain(professorDto);
        return professorMapper
                .toDto(professorService.updateProfessor(id, professor));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
    }

}
