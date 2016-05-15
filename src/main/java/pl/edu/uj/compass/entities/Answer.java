package pl.edu.uj.compass.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Question question;

    @ManyToOne
    private Search search;

    @ManyToMany(targetEntity = QuestionOption.class)
    private List<QuestionOption> questionOptions;

    public Answer() {}

    public Answer(Search search, Question question, List<QuestionOption> questionOptions) {
        this.search = search;
        this.question = question;
        this.questionOptions = questionOptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
