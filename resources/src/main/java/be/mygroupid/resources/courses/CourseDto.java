package be.mygroupid.resources.courses;

import be.mygroupid.domain.courses.Category;

//copied from example exercise
public class CourseDto {

    private Integer id;
    private String name;
    private double studyPoints;
    private Category category;
    private Integer professorId;

    public static CourseDto courseDto() { return new CourseDto(); }

    public CourseDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public CourseDto withName(String name) {
        this.name = name;
        return this;
    }

    public CourseDto withStudyPoints(double studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CourseDto withCategory(Category category) {
        this.category = category;
        return this;
    }

    public CourseDto withProfessorId(Integer professorId) {
        this.professorId = professorId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getStudyPoints() {
        return studyPoints;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getProfessorId() {
        return professorId;
    }
}
