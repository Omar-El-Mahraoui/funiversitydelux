package be.mygroupid.services.courses;

import be.mygroupid.domain.courses.Category;
import be.mygroupid.domain.courses.Course;

import static be.mygroupid.domain.courses.Course.CourseBuilder.course;

//adapted code from example funiversity
public class CourseTestBuilder {

    private Integer id;
    private String name;
    private double studyPoints;
    private Category category;
    private Integer professorId;

    private CourseTestBuilder() {
        id = 0;
        name = "Java course";
        studyPoints = 5.0;
        category = Category.COMPUTER_SCIENCES1;
        professorId = 1;
    }

    public static CourseTestBuilder aCourse() {
        return new CourseTestBuilder();
    }

    public Course build() {
        return course()
                .withId(id)
                .withName(name)
                .withStudyPoints(studyPoints)
                .withCategory(category)
                .withProfessorId(professorId)
                .build();
    }

    public CourseTestBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public CourseTestBuilder withoutId() {
        this.id = null;
        return this;
    }

    public CourseTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CourseTestBuilder withStudyPoints(double studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CourseTestBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public CourseTestBuilder withProfessorId(Integer professorId) {
        this.professorId = professorId;
        return this;
    }

}