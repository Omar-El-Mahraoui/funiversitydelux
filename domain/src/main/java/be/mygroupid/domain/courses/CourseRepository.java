package be.mygroupid.domain.courses;

import java.util.*;

public class CourseRepository {

    private static Integer databaseIndex = 0;
    private Map<Integer, Course> courses;

    public CourseRepository() {
        this.courses = new HashMap<Integer, Course>();
        storeCourse(new Course("java course 1",5.0, Category.COMPUTER_SCIENCES, 0));
        storeCourse(new Course("java course 2",5.0, Category.COMPUTER_SCIENCES, 1));
        storeCourse(new Course("java course 3",5.0, Category.COMPUTER_SCIENCES, 2));
    }

    public Course storeCourse(Course course) {
        course.setId(databaseIndex++);
        courses.put(course.getId(), course);
        return course;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(new ArrayList<Course>(courses.values()));
    }

    public Course getCourse(Integer id) {
        return courses.get(id);
    }

    public Course updateCourse(Course course) {
        courses.put(course.getId(), course);
        return course;
    }

    public void deleteCourse(Integer id) {
        courses.remove(id);
    }

}
