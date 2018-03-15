package be.mygroupid.domain.courses;

public class Course {

    private String id;
    private String name;
    private double studyPoints;
    private Category category;
    private String professorId;

    private Course() {}

    Course(String name, double studyPoints, Category category, String professorId) {
        this.name = name;
        this.studyPoints = studyPoints;
        this.category = category;
        this.professorId = professorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(double studyPoints) {
        this.studyPoints = studyPoints;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public static class CourseBuilder {

        private String id;
        private String name;
        private double studyPoints;
        private Category category;
        private String professorId;

        private CourseBuilder() {}

        public static CourseBuilder course() { return new CourseBuilder(); }

        public Course build() {
            Course course = new Course();
            course.setId(id);
            course.setName(name);
            course.setStudyPoints(studyPoints);
            course.setCategory(category);
            course.setProfessorId(professorId);
            return course;
        }

        public CourseBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CourseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder withStudyPoints(double studyPoints) {
            this.studyPoints = studyPoints;
            return this;
        }

        public CourseBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public CourseBuilder withProfessorId(String professorId) {
            this.professorId = professorId;
            return this;
        }
    }
}
