/*
package be.mygroupid.services.courses;

import be.mygroupid.domain.courses.Course;
import be.mygroupid.domain.courses.CourseRepository;
import be.mygroupid.domain.professors.ProfessorRepository;
import be.mygroupid.services.professors.ProfessorService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.List;

import static be.mygroupid.services.courses.CourseTestBuilder.aCourse;
import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private CourseRepository courseRepository;
    private ProfessorService professorService;

    @InjectMocks
    private CourseService courseService;

    @Test
    public void getCourses_given3Courses_thenReturnListOf3Courses() {
        List<Course> expectedCourses = newArrayList(
                aCourse().build(),
                aCourse().build(),
                aCourse().build()
        );
        when(courseRepository.getCourses())
                .thenReturn(expectedCourses);

        List<Course> actualCourses = courseService.getCourses();

        assertThat(actualCourses)
                .containsExactly(expectedCourses.toArray(new Course[0]));
    }


}
*/
