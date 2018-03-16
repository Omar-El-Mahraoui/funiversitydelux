package be.mygroupid.resources.courses;

import be.mygroupid.domain.courses.Course;

import javax.inject.Named;

import static be.mygroupid.domain.courses.Course.CourseBuilder.course;
import static be.mygroupid.resources.courses.CourseDto.courseDto;

// copied from example exercise

@Named
public class CourseMapper {

    CourseDto toDto(Course course) {
        return courseDto()
                .withId(course.getId())
                .withName(course.getName())
                .withStudyPoints(course.getStudyPoints())
                .withCategory(course.getCategory())
                .withProfessorId(course.getProfessorId());
    }

    Course toDomain(CourseDto courseDto) {
        return course()
                .withId(courseDto.getId())
                .withName(courseDto.getName())
                .withStudyPoints(courseDto.getStudyPoints())
                .withCategory(courseDto.getCategory())
                .withProfessorId(courseDto.getProfessorId())
                .build();
    }

}
