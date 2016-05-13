package runners;

import entities.*;
import matcher.OrgMatcher;
import matcher.RankedOrgMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
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
@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("entities")
@ComponentScan(basePackages = { "matcher" })
//@EnableAutoConfiguration
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
                                    OrgQuestionRepository orgQuestionRepository,
                                    OrgOptionRepository orgOptionRepository,
                                    SearchRepository searchRepository,
                                    OrgMatcher orgMatcher) {
        return (args) -> {
            Question q1 = new Question("Do you like corporate environment?");

            questionRepository.save(q1);

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

            Question q2 = new Question("Which technologies do you know?");

            questionRepository.save(q2);

            QuestionOption q2opt1 = new QuestionOption(q2, "Java EE");
            QuestionOption q2opt2 = new QuestionOption(q2, "MySQL");
            QuestionOption q2opt3 = new QuestionOption(q2, "Oracle");
            QuestionOption q2opt4 = new QuestionOption(q2, "Ruby On Rails");
            QuestionOption q2opt5 = new QuestionOption(q2, "Angular");
            QuestionOption q2opt6 = new QuestionOption(q2, "Spring");
            QuestionOption q2opt7 = new QuestionOption(q2, "Git");

            optionRepository.save(Arrays.asList(
                q2opt1,
                q2opt2,
                q2opt3,
                q2opt4,
                q2opt5,
                q2opt6,
                q2opt7
            ));

            Question q3 = new Question("How many years of experience have you got?");

            questionRepository.save(q3);

            QuestionOption q3opt1 = new QuestionOption(q3, "0..2");
            QuestionOption q3opt2 = new QuestionOption(q3, "2..4");
            QuestionOption q3opt3 = new QuestionOption(q3, "4..6");

            optionRepository.save(Arrays.asList(
                    q3opt1,
                    q3opt2,
                    q3opt3
            ));

            Org o1 = new Org("EPAM");

            orgRepository.save(o1);

            OrgQuestion o1q1 = new OrgQuestion(o1, q1);
            OrgQuestion o1q2 = new OrgQuestion(o1, q2);
            OrgQuestion o1q3 = new OrgQuestion(o1, q3);

            orgQuestionRepository.save(o1q1);
            orgQuestionRepository.save(o1q2);
            orgQuestionRepository.save(o1q3);

            o1q1.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o1q1, q1opt1, 1),
                    new OrgQuestionOption(o1q1, q1opt2, 2),
                    new OrgQuestionOption(o1q1, q1opt3, 3),
                    new OrgQuestionOption(o1q1, q1opt4, 4),
                    new OrgQuestionOption(o1q1, q1opt5, 5)
            ));

            orgOptionRepository.save(o1q1.getOrgQuestionOptions());
            orgQuestionRepository.save(o1q1);

            o1q2.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o1q2, q1opt1, 5),
                    new OrgQuestionOption(o1q2, q1opt2, 1),
                    new OrgQuestionOption(o1q2, q1opt3, 5),
                    new OrgQuestionOption(o1q2, q1opt4, 1),
                    new OrgQuestionOption(o1q2, q1opt5, 2),
                    new OrgQuestionOption(o1q2, q1opt5, 5),
                    new OrgQuestionOption(o1q2, q1opt5, 4)
            ));

            orgOptionRepository.save(o1q2.getOrgQuestionOptions());
            orgQuestionRepository.save(o1q2);

            o1q3.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o1q3, q1opt1, 1),
                    new OrgQuestionOption(o1q3, q1opt2, 3),
                    new OrgQuestionOption(o1q3, q1opt3, 5)
            ));

            orgOptionRepository.save(o1q3.getOrgQuestionOptions());
            orgQuestionRepository.save(o1q3);

            Org o2 = new Org("u2i");

            orgRepository.save(o2);

            OrgQuestion o2q1 = new OrgQuestion(o2, q1);
            OrgQuestion o2q2 = new OrgQuestion(o2, q2);
            OrgQuestion o2q3 = new OrgQuestion(o2, q3);

            orgQuestionRepository.save(o2q1);
            orgQuestionRepository.save(o2q2);
            orgQuestionRepository.save(o2q3);

            o2q1.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o2q1, q1opt1, 5),
                    new OrgQuestionOption(o2q1, q1opt2, 5),
                    new OrgQuestionOption(o2q1, q1opt3, 3),
                    new OrgQuestionOption(o2q1, q1opt4, 2),
                    new OrgQuestionOption(o2q1, q1opt5, 1)
            ));

            orgOptionRepository.save(o2q1.getOrgQuestionOptions());
            orgQuestionRepository.save(o2q1);

            o2q2.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o2q2, q1opt1, 1),
                    new OrgQuestionOption(o2q2, q1opt2, 5),
                    new OrgQuestionOption(o2q2, q1opt3, 3),
                    new OrgQuestionOption(o2q2, q1opt4, 5),
                    new OrgQuestionOption(o2q2, q1opt5, 5),
                    new OrgQuestionOption(o2q2, q1opt5, 3),
                    new OrgQuestionOption(o2q2, q1opt5, 5)
            ));

            orgOptionRepository.save(o2q2.getOrgQuestionOptions());
            orgQuestionRepository.save(o2q2);

            o2q3.setOrgQuestionOptions(Arrays.asList(
                    new OrgQuestionOption(o2q3, q1opt1, 2),
                    new OrgQuestionOption(o2q3, q1opt2, 5),
                    new OrgQuestionOption(o2q3, q1opt3, 5)
            ));

            orgOptionRepository.save(o2q3.getOrgQuestionOptions());

            User u1 = new User("user #1", "u1@email.com");

            userRepository.save(u1);

            Search u1s1 = new Search(u1);

            searchRepository.save(u1s1);

            u1s1.setAnswers(Arrays.asList(
                    new Answer(u1s1, q1, Arrays.asList(q1opt3)),
                    new Answer(u1s1, q2, Arrays.asList(q2opt1, q2opt2, q2opt6, q2opt7)),
                    new Answer(u1s1, q3, Arrays.asList(q3opt2))
            ));

            answerRepository.save(u1s1.getAnswers());

            User u2 = new User("user #2", "u2@email.com");

            userRepository.save(u2);

            Search u2s1 = new Search(u2);

            searchRepository.save(u2s1);

            u2s1.setAnswers(Arrays.asList(
                    new Answer(u2s1, q1, Arrays.asList(q1opt4)),
                    new Answer(u2s1, q2, Arrays.asList(q2opt1, q2opt2, q2opt3, q2opt6)),
                    new Answer(u2s1, q3, Arrays.asList(q3opt3))
            ));

            answerRepository.save(u2s1.getAnswers());

            User u3 = new User("user #3", "u3@email.com");

            userRepository.save(u3);

            Search u3s1 = new Search(u3);

            searchRepository.save(u3s1);

            u3s1.setAnswers(Arrays.asList(
                    new Answer(u3s1, q1, Arrays.asList(q1opt3)),
                    new Answer(u3s1, q2, Arrays.asList(q2opt5, q2opt7)),
                    new Answer(u3s1, q3, Arrays.asList(q3opt2))
            ));

            answerRepository.save(u3s1.getAnswers());

            // and the actual check
            List<RankedOrgMatch> u1matches = orgMatcher.match(u1s1);
            logger.info(String.format("User1 matches are: %s\n", u1matches));

            List<RankedOrgMatch> u2matches = orgMatcher.match(u2s1);
            logger.info(String.format("User2 matches are: %s\n", u2matches));

            List<RankedOrgMatch> u3matches = orgMatcher.match(u3s1);
            logger.info(String.format("User3 matches are: %s\n", u3matches));
        };
    }
}
