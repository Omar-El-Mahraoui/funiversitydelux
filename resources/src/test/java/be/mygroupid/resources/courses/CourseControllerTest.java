package be.mygroupid.resources.courses;

import be.mygroupid.application.Application;
import be.mygroupid.domain.courses.CourseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static be.mygroupid.resources.courses.CourseTestBuilder.aCourse;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

// adapted code from example exercise

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {

    @LocalServerPort
    private int port;

    @Inject
    private CourseRepository courseRepository;

    /**
     * We mimic Transactional database behavior using our clear() method.
     * Never do this for a real world application, with a real database.
     */
    @Before
    public void clearDatabase() {
        courseRepository.clear();
    }

    @Test
    public void getCourses() {
        courseRepository.storeCourse(aCourse().build());
        courseRepository.storeCourse(aCourse().build());

        CourseDto[] courses = new TestRestTemplate().getForObject(
                format("http://localhost:%s/%s", port, "courses")
                , CourseDto[].class
        );

        assertThat(courses).hasSize(2);

    }

}