package be.mygroupid.resources.courses;


import be.mygroupid.services.courses.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// copied code from example
@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseService courseService;
    private CourseMapper courseMapper;

    @Inject
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getCourses() {
        return courseService.getCourses().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getCoursesByStudyPoints/{studyPoints}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public  List<CourseDto> getAllCoursesWithSpecifiedStudyPoints(@PathVariable("studyPoints") Integer studyPoints) {
        return courseService.getCourses().stream()
                .filter(course->course.getStudyPoints() == studyPoints)
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDto getCourse(@PathVariable("id") Integer id) {
        return courseMapper
                .toDto(courseService.getCourse(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseMapper
                .toDto(courseService.createCourse(courseMapper.toDomain(courseDto)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDto updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
        return courseMapper
                .toDto(courseService.updateCourse(id, courseMapper.toDomain(courseDto)));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

}
