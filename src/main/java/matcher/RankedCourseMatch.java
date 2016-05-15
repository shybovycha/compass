package matcher;

import entities.Course;

/**
 * Created by shybovycha on 13/05/16.
 */
public class RankedCourseMatch {
    private Course course;
    private Integer rank;

    public RankedCourseMatch(Course course, Integer rank) {
        this.course = course;
        this.rank = rank;
    }

    public Course getCourse() {
        return course;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.course.getName(), this.rank);
    }
}
