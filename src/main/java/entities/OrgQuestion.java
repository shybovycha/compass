package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class OrgQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Org org;

    @OneToOne
    private Question question;

    @OneToMany(targetEntity = OrgQuestionOption.class, fetch = FetchType.EAGER)
    private List<OrgQuestionOption> orgQuestionOptions;

    public OrgQuestion() {}

    public OrgQuestion(Org org, Question question) {
        this.org = org;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<OrgQuestionOption> getOrgQuestionOptions() {
        return orgQuestionOptions;
    }

    public void setOrgQuestionOptions(List<OrgQuestionOption> orgQuestionOptions) {
        this.orgQuestionOptions = orgQuestionOptions;
    }
}
