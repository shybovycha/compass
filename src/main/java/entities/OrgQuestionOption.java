package entities;

import javax.persistence.*;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class OrgQuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private OrgQuestion orgQuestion;

    @OneToOne
    private QuestionOption questionOption;

    private int weight;

    public OrgQuestionOption() {}

    public OrgQuestionOption(OrgQuestion orgQuestion, QuestionOption opt, int weight) {
        this.orgQuestion = orgQuestion;
        this.questionOption = opt;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrgQuestion getOrgQuestion() {
        return orgQuestion;
    }

    public void setOrgQuestion(OrgQuestion orgQuestion) {
        this.orgQuestion = orgQuestion;
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
