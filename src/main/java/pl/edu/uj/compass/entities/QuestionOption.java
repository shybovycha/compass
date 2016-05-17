package pl.edu.uj.compass.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by shybovycha on 12/05/16.
 */
@JsonIgnoreProperties(value = { "question" })
@Entity
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String value;

    @ManyToOne
    private Question question;

    public QuestionOption() {}

    public QuestionOption(String value) {
        this.value = value;
    }

    public QuestionOption(Question question, String value) {
        this.question = question;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
