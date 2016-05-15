package runners;

import entities.*;
import matcher.CourseMatcher;
import matcher.RankedCourseMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shybovycha on 13/05/16.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("entities")
@ComponentScan(basePackages = { "matcher" })
public class ConsoleRunner {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleRunner.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsoleRunner.class, args);
    }

    @Bean
    public CommandLineRunner runner(QuestionRepository questionRepository,
                                    AnswerRepository answerRepository,
                                    UserRepository userRepository,
                                    OptionRepository optionRepository,
                                    OrgRepository orgRepository,
                                    CourseQuestionRepository courseQuestionRepository,
                                    CourseOptionRepository courseOptionRepository,
                                    SearchRepository searchRepository,
                                    CourseRepository courseRepository,
                                    CourseMatcher courseMatcher) {
        return (args) -> {
            // Create courses
            Course c1 = new Course("Software Engineering");
            Course c2 = new Course("Computer Science");
            Course c3 = new Course("Bioinformatics");

            courseRepository.save(Arrays.asList(c1, c2, c3));

            // Create questions...
            Question q1 = new Question("How curious are you about what are living beings inside?", Question.Style.RANKING);

            questionRepository.save(q1);

            // ...and their options
            QuestionOption q1opt1 = new QuestionOption(q1, "1");
            QuestionOption q1opt2 = new QuestionOption(q1, "2");
            QuestionOption q1opt3 = new QuestionOption(q1, "3");
            QuestionOption q1opt4 = new QuestionOption(q1, "4");
            QuestionOption q1opt5 = new QuestionOption(q1, "5");

            optionRepository.save(Arrays.asList(
                    q1opt1,
                    q1opt2,
                    q1opt3,
                    q1opt4,
                    q1opt5
            ));

            Question q2 = new Question("Are you about to discover something inexistent or create something in a totally awesome way?", Question.Style.RANGING);

            questionRepository.save(q2);

            QuestionOption q2opt1 = new QuestionOption(q2, "Only discovery!");
            QuestionOption q2opt2 = new QuestionOption(q2, "Discovery is nice, but I want to create too...");
            QuestionOption q2opt3 = new QuestionOption(q2, "Creating stuff is my passion!");

            optionRepository.save(Arrays.asList(
                q2opt1,
                q2opt2,
                q2opt3
            ));

            Question q3 = new Question("What activities would you like to do the most (on a daily basis)?", Question.Style.MULTIPLE_CHOICE);

            questionRepository.save(q3);

            QuestionOption q3opt1 = new QuestionOption(q3, "Making theory to play nice in practice");
            QuestionOption q3opt2 = new QuestionOption(q3, "Develop new ways of doing something");
            QuestionOption q3opt3 = new QuestionOption(q3, "Create new tools and things");
            QuestionOption q3opt4 = new QuestionOption(q3, "Working in a team of experienced seniors");
            QuestionOption q3opt5 = new QuestionOption(q3, "Working in an enthusiastic team of same-agers");

            optionRepository.save(Arrays.asList(
                    q3opt1,
                    q3opt2,
                    q3opt3,
                    q3opt4,
                    q3opt5
            ));

            // Set the weights, linking questions/options to courses
            // course #1 questions
            CourseQuestion c1q1 = new CourseQuestion(c1, q1);
            CourseQuestion c1q2 = new CourseQuestion(c1, q2);
            CourseQuestion c1q3 = new CourseQuestion(c1, q3);

            courseQuestionRepository.save(c1q1);
            courseQuestionRepository.save(c1q2);
            courseQuestionRepository.save(c1q3);

            c1.setCourseQuestions(Arrays.asList(c1q1, c1q2, c1q3));
            courseRepository.save(c1);

            // course #1, question #1
            c1q1.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c1q1, q1opt1, 1),
                    new CourseQuestionOption(c1q1, q1opt2, 1),
                    new CourseQuestionOption(c1q1, q1opt3, 1),
                    new CourseQuestionOption(c1q1, q1opt4, 1),
                    new CourseQuestionOption(c1q1, q1opt5, 1)
            ));

            courseOptionRepository.save(c1q1.getCourseQuestionOptions());
            courseQuestionRepository.save(c1q1);

            // course #1, question #2
            c1q2.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c1q2, q2opt1, 3),
                    new CourseQuestionOption(c1q2, q2opt2, 4),
                    new CourseQuestionOption(c1q2, q2opt3, 5)
            ));

            courseOptionRepository.save(c1q2.getCourseQuestionOptions());
            courseQuestionRepository.save(c1q2);

            // course #1, question #3
            c1q3.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c1q3, q3opt1, 5),
                    new CourseQuestionOption(c1q3, q3opt2, 3),
                    new CourseQuestionOption(c1q3, q3opt3, 5),
                    new CourseQuestionOption(c1q3, q3opt4, 4),
                    new CourseQuestionOption(c1q3, q3opt5, 5)
            ));

            courseOptionRepository.save(c1q3.getCourseQuestionOptions());
            courseQuestionRepository.save(c1q3);

            // course #2 questions
            CourseQuestion c2q1 = new CourseQuestion(c2, q1);
            CourseQuestion c2q2 = new CourseQuestion(c2, q2);
            CourseQuestion c2q3 = new CourseQuestion(c2, q3);

            courseQuestionRepository.save(c2q1);
            courseQuestionRepository.save(c2q2);
            courseQuestionRepository.save(c2q3);

            c2.setCourseQuestions(Arrays.asList(c2q1, c2q2, c2q3));
            courseRepository.save(c2);

            // course #2, question #1
            c2q1.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c2q1, q1opt1, 1),
                    new CourseQuestionOption(c2q1, q1opt2, 1),
                    new CourseQuestionOption(c2q1, q1opt3, 1),
                    new CourseQuestionOption(c2q1, q1opt4, 1),
                    new CourseQuestionOption(c2q1, q1opt5, 1)
            ));

            courseOptionRepository.save(c2q1.getCourseQuestionOptions());
            courseQuestionRepository.save(c2q1);

            // course #2, question #2
            c2q2.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c2q2, q2opt1, 5),
                    new CourseQuestionOption(c2q2, q2opt2, 4),
                    new CourseQuestionOption(c2q2, q2opt3, 3)
            ));

            courseOptionRepository.save(c2q2.getCourseQuestionOptions());
            courseQuestionRepository.save(c2q2);

            // course #2, question #3
            c2q3.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c2q3, q3opt1, 5),
                    new CourseQuestionOption(c2q3, q3opt2, 5),
                    new CourseQuestionOption(c2q3, q3opt3, 3),
                    new CourseQuestionOption(c2q3, q3opt4, 5),
                    new CourseQuestionOption(c2q3, q3opt5, 3)
            ));

            courseOptionRepository.save(c2q3.getCourseQuestionOptions());
            courseQuestionRepository.save(c2q3);

            // course #1 questions
            CourseQuestion c3q1 = new CourseQuestion(c3, q1);
            CourseQuestion c3q2 = new CourseQuestion(c3, q2);
            CourseQuestion c3q3 = new CourseQuestion(c3, q3);

            courseQuestionRepository.save(c3q1);
            courseQuestionRepository.save(c3q2);
            courseQuestionRepository.save(c3q3);

            c3.setCourseQuestions(Arrays.asList(c3q1, c3q2, c3q3));
            courseRepository.save(c3);

            // course #3, question #1
            c3q1.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c3q1, q1opt1, 1),
                    new CourseQuestionOption(c3q1, q1opt2, 2),
                    new CourseQuestionOption(c3q1, q1opt3, 3),
                    new CourseQuestionOption(c3q1, q1opt4, 4),
                    new CourseQuestionOption(c3q1, q1opt5, 5)
            ));

            courseOptionRepository.save(c3q1.getCourseQuestionOptions());
            courseQuestionRepository.save(c3q1);

            // course #3, question #2
            c3q2.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c3q2, q2opt1, 5),
                    new CourseQuestionOption(c3q2, q2opt2, 3),
                    new CourseQuestionOption(c3q2, q2opt3, 5)
            ));

            courseOptionRepository.save(c3q2.getCourseQuestionOptions());
            courseQuestionRepository.save(c3q2);

            // course #3, question #3
            c3q3.setCourseQuestionOptions(Arrays.asList(
                    new CourseQuestionOption(c3q3, q3opt1, 3),
                    new CourseQuestionOption(c3q3, q3opt2, 5),
                    new CourseQuestionOption(c3q3, q3opt3, 5),
                    new CourseQuestionOption(c3q3, q3opt4, 5),
                    new CourseQuestionOption(c3q3, q3opt5, 3)
            ));

            courseOptionRepository.save(c3q3.getCourseQuestionOptions());
            courseQuestionRepository.save(c3q3);


            // Create organizations and link them to courses
            Org o1 = new Org("Uniwersytet Jagielloński");

            o1.setCourses(Arrays.asList(c1, c2, c3));

            orgRepository.save(o1);

            Org o2 = new Org("Akademia Górniczo-Hutnicza");

            o2.setCourses(Arrays.asList(c1, c2, c3));

            orgRepository.save(o2);

            Org o3 = new Org("Politechnika Wrocławska");

            o3.setCourses(Arrays.asList(c1, c2));

            orgRepository.save(o3);

            Org o4 = new Org("Wyższa Szkoła Informatyczna");

            o4.setCourses(Arrays.asList(c1));

            orgRepository.save(o4);

            // Create a couple of users

            // user, who likes to create and is rather interested in biology
            User u1 = new User("user #1", "u1@email.com");

            userRepository.save(u1);

            Search u1s1 = new Search(u1);

            searchRepository.save(u1s1);

            u1s1.setAnswers(Arrays.asList(
                    new Answer(u1s1, q1, Arrays.asList(q1opt4)),
                    new Answer(u1s1, q2, Arrays.asList(q2opt2)),
                    new Answer(u1s1, q3, Arrays.asList(q3opt2, q3opt3, q3opt4))
            ));

            answerRepository.save(u1s1.getAnswers());
            searchRepository.save(u1s1);

            // user, which is math-oriented genius
            User u2 = new User("user #2", "u2@email.com");

            userRepository.save(u2);

            Search u2s1 = new Search(u2);

            searchRepository.save(u2s1);

            u2s1.setAnswers(Arrays.asList(
                    new Answer(u2s1, q1, Arrays.asList(q1opt1)),
                    new Answer(u2s1, q2, Arrays.asList(q2opt1)),
                    new Answer(u2s1, q3, Arrays.asList(q3opt1, q3opt2, q3opt4))
            ));

            answerRepository.save(u2s1.getAnswers());
            searchRepository.save(u2s1);

            // mid-player
            User u3 = new User("user #3", "u3@email.com");

            userRepository.save(u3);

            Search u3s1 = new Search(u3);

            searchRepository.save(u3s1);

            u3s1.setAnswers(Arrays.asList(
                    new Answer(u3s1, q1, Arrays.asList(q1opt3)),
                    new Answer(u3s1, q2, Arrays.asList(q2opt2)),
                    new Answer(u3s1, q3, Arrays.asList(q3opt1, q3opt4, q3opt5))
            ));

            answerRepository.save(u3s1.getAnswers());
            searchRepository.save(u3s1);

            // and the actual check
            List<RankedCourseMatch> u1matches = courseMatcher.match(u1s1);
            logger.info(String.format("User1 matches are: %s\n", u1matches));

            List<RankedCourseMatch> u2matches = courseMatcher.match(u2s1);
            logger.info(String.format("User2 matches are: %s\n", u2matches));

            List<RankedCourseMatch> u3matches = courseMatcher.match(u3s1);
            logger.info(String.format("User3 matches are: %s\n", u3matches));
        };
    }
}
