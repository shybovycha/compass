package pl.edu.uj.compass.entities;

import javax.persistence.*;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class CourseQuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private CourseQuestion courseQuestion;

    @OneToOne
    private QuestionOption questionOption;

    private int weight;

    public CourseQuestionOption() {}

    public CourseQuestionOption(CourseQuestion courseQuestion, QuestionOption opt, int weight) {
        this.courseQuestion = courseQuestion;
        this.questionOption = opt;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CourseQuestion getCourseQuestion() {
        return courseQuestion;
    }

    public void setCourseQuestion(CourseQuestion courseQuestion) {
        this.courseQuestion = courseQuestion;
    }

    public QuestionOption getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(QuestionOption questionOption) {
        this.questionOption = questionOption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
