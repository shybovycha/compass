package pl.edu.uj.compass.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shybovycha on 12/05/16.
 */
@JsonIgnoreProperties(value = { "courseQuestions" })
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("title")
    private String name;

    @Lob
    private String description;

    @OneToMany(targetEntity = CourseQuestion.class, fetch = FetchType.EAGER)
    private List<CourseQuestion> courseQuestions;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseQuestion> getCourseQuestions() {
        return courseQuestions;
    }

    public void setCourseQuestions(List<CourseQuestion> courseQuestions) {
        this.courseQuestions = courseQuestions;
    }
}
