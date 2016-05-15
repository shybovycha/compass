package pl.edu.uj.compass.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class CourseQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Course course;

    @OneToOne
    private Question question;

    @OneToMany(targetEntity = CourseQuestionOption.class, fetch = FetchType.EAGER)
    private List<CourseQuestionOption> courseQuestionOptions;

    public CourseQuestion() {}

    public CourseQuestion(Course course, Question question) {
        this.course = course;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<CourseQuestionOption> getCourseQuestionOptions() {
        return courseQuestionOptions;
    }

    public void setCourseQuestionOptions(List<CourseQuestionOption> courseQuestionOptions) {
        this.courseQuestionOptions = courseQuestionOptions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
