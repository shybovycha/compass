package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shybovycha on 12/05/16.
 */
@Entity
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @OneToMany(targetEntity = Answer.class, fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Search() {}

    public Search(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
