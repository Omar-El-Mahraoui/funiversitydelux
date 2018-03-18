package be.mygroupid.services.courses;

import be.mygroupid.domain.courses.Course;
import be.mygroupid.domain.courses.CourseRepository;
import be.mygroupid.services.exceptions.IllegalFieldFoundException;
import be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction;
import be.mygroupid.services.exceptions.UnknownResourceException;
import be.mygroupid.services.professors.ProfessorService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction.CREATE;
import static be.mygroupid.services.exceptions.IllegalFieldFoundException.CrudAction.UPDATE;

@Named
public class CourseService {

    private final CourseRepository courseRepository;
    private final ProfessorService professorService;

    @Inject
    public CourseService(CourseRepository courseRepository, ProfessorService professorService) {
        this.courseRepository = courseRepository;
        this.professorService = professorService;
    }

    public List<Course> getCourses() {
        return courseRepository.getCourses();
    }

    public Course getCourse(Integer id) {
        assertCourseIsPresent(courseRepository.getCourse(id));
        return courseRepository.getCourse(id);
    }

    public Course createCourse(Course course) {
        assertCourseIdIsNotPresent(course, CREATE);
        professorService.assertProfessorIsPresent(professorService.getProfessor(course.getProfessorId()));
        return courseRepository.storeCourse(course);
    }

    public Course updateCourse(Integer id, Course course) {
        assertCourseIdIsNotPresent(course, UPDATE);
        assertCourseIsPresent(courseRepository.getCourse(id));
        course.setId(id);
        return courseRepository.updateCourse(course);
    }

    public void deleteCourse(Integer id) {
        assertCourseIsPresent(courseRepository.getCourse(id));
        courseRepository.deleteCourse(id);
    }

    private void assertCourseIsPresent(Course professor) {
        if (professor == null) {
            throw new UnknownResourceException("ID", Course.class.getSimpleName());
        }
    }

    private void assertCourseIdIsNotPresent(Course course, CrudAction action) {
        if (course.getId() != null) {
            throw new IllegalFieldFoundException("ID", Course.class.getSimpleName(), action);
        }
    }

}
