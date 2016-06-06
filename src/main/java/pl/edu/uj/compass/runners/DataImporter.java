package pl.edu.uj.compass.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.edu.uj.compass.entities.*;
import pl.edu.uj.compass.matcher.CourseMatcher;
import pl.edu.uj.compass.repositories.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shybovycha on 06/06/16.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl/edu/uj/compass/entities")
@ComponentScan(basePackages = {"pl.edu.uj.compass.matcher"})
public class DataImporter {
    private static final Logger logger = LoggerFactory.getLogger(DataImporter.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(DataImporter.class)
                .web(false)
                .run(args);
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
            List<String> questionTexts = Arrays.asList("Do you like to watch the machines work?",
                    "Do you like to care for animals?",
                    "Do you like to get acquainted with the work of a teacher or a doctor?",
                    "Do you like to read poetry?",
                    "Do you like to study biology?",
                    "Do you like to read books?",
                    "Do you like to care for other people?",
                    "Do you know the laws of chemical?",
                    "Do you like to fix little technical devices?",
                    "Do you like to write essays?",
                    "Do you like to analyze various phenomena?",
                    "Do you like to hear about other people's problems?",
                    "Do you like to visit enterprises, workshops?",
                    "Do you like studying history?",
                    "Do you like to solve math problems?",
                    "Do you like to speak to an audience, for example, to make presentations in front of the class?",
                    "Do you like to observe the life of plants and animals?",
                    "Do you like to explore the construction of various technical devices?",
                    "Do you like to study Russian language?",
                    "Do you like to read about discoveries in physics?",
                    "Do you like to help others in homework?",
                    "Do you like to learn the experiments from the field of genetics?",
                    "Do you like to design or analyze technical projects?",
                    "Do you like to go to the theatre?",
                    "Do you like to be guided in life logical thinking?",
                    "Do you like to tell children stories?",
                    "Do you like to make parts of the model cars, ships, aircraft, etc.?",
                    "Do you like to grow plants?",
                    "Do you like to read about modern technologies?",
                    "Do you like to perform small repairs in the house?",
                    "Do you like to read magazines about life?",
                    "Do you like to learn the history of the world?",
                    "Do you like studying science?",
                    "Do you like to give others support in difficult situations?",
                    "Do you like to visit the technical exhibition?",
                    "Do you like to participate in contests, competitions, historical?",
                    "Do you like to read about computer programs?",
                    "Do you like to fix different devices?",
                    "Do you like to give commands?",
                    "Do you like to motivate others to work?",
                    "Do you like to support others in difficult times?",
                    "Do you like to design the interior design?",
                    "Do you like remove minor accident?",
                    "Do you like to manage other people's work?",
                    "Do you like to draw?",
                    "Do you hold classes?",
                    "Do you like to write articles?",
                    "Do you like to plan trips?",
                    "Do you like to care for the sick?",
                    "Do you like to take pictures?",
                    "Do you like to make the balance of the costs?");

            List<String> majorsTexts = Arrays.asList(
                    "Medical Analytics",
                    "Administration",
                    "Informatics",
                    "Medicine",
                    "Design",
                    "Psychology",
                    "Mechatronics",
                    "Philology",
                    "Finance and Accounting",
                    "Pedagogy");

            List<String> orgsTexts = Arrays.asList(
                    "Akademia Górniczo-Hutnicza",
                    "Uniwersytet Jagielloński",
                    "Uniwersytet Warszawski",
                    "Uniwersytet Adama Mickiewicza w Poznaniu",
                    "Szkoła Główna Handlowa",
                    "Akademia Sztuk Pięknych w Krakowie");

            /*optionRepository.deleteAll();
            questionRepository.deleteAll();
            courseQuestionRepository.deleteAll();
            courseRepository.deleteAll();
            orgRepository.deleteAll();*/

//            questionTexts.stream().forEach(t -> {
//                Question q = new Question(t, Question.Style.RANKING);
//                questionRepository.save(q);
//                List<QuestionOption> options = Arrays.asList(new QuestionOption(q, "Yes"), new QuestionOption(q, "No"));
//                options.stream().forEach(optionRepository::save);
//                q.setQuestionOptions(options);
//                questionRepository.save(q);
//            });
//            courseRepository.save(majorsTexts.stream().map(t -> new Course(t)).collect(Collectors.toList()));
//            orgRepository.save(orgsTexts.stream().map(t -> new Org(t)).collect(Collectors.toList()));

//            {
//                Org o = orgRepository.findByName("Akademia Górniczo-Hutnicza");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Medical Analytics"), courseRepository.findByName("Informatics"), courseRepository.findByName("Mechatronics")));
//                orgRepository.save(o);
//            }
//
//            {
//                Org o = orgRepository.findByName("Uniwersytet Jagielloński");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Medical Analytics"), courseRepository.findByName("Administration"), courseRepository.findByName("Informatics"), courseRepository.findByName("Medicine"), courseRepository.findByName("Psychology"), courseRepository.findByName("Philology"), courseRepository.findByName("Pedagogy")));
//                orgRepository.save(o);
//            }
//
//            {
//                Org o = orgRepository.findByName("Uniwersytet Warszawski");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Administration"), courseRepository.findByName("Informatics"), courseRepository.findByName("Psychology"), courseRepository.findByName("Philology"), courseRepository.findByName("Finance and Accounting"), courseRepository.findByName("Pedagogy")));
//                orgRepository.save(o);
//            }
//
//            {
//                Org o = orgRepository.findByName("Uniwersytet Adama Mickiewicza w Poznaniu");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Administration"), courseRepository.findByName("Informatics"), courseRepository.findByName("Psychology"), courseRepository.findByName("Philology"), courseRepository.findByName("Pedagogy")));
//                orgRepository.save(o);
//            }
//
//            {
//                Org o = orgRepository.findByName("Szkoła Główna Handlowa");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Administration"), courseRepository.findByName("Finance and Accounting")));
//                orgRepository.save(o);
//            }
//
//            {
//                Org o = orgRepository.findByName("Akademia Sztuk Pięknych w Krakowie");
//                o.setCourses(Arrays.asList(courseRepository.findByName("Design")));
//                orgRepository.save(o);
//            }

            /*{
                Course c = courseRepository.findByName("Medical Analytics");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Administration");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Informatics");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Medicine");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Design");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                */
            {Course c = courseRepository.findByName("Design");
                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Psychology");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Mechatronics");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Philology");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Finance and Accounting");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }

            {
                Course c = courseRepository.findByName("Pedagogy");
                {
                    Question q = questionRepository.findByTitle("Do you like to watch the machines work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to get acquainted with the work of a teacher or a doctor?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read poetry?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study biology?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read books?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for other people?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you know the laws of chemical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix little technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write essays?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to analyze various phenomena?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to hear about other people's problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit enterprises, workshops?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying history?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to solve math problems?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to speak to an audience, for example, to make presentations in front of the class?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to observe the life of plants and animals?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to explore the construction of various technical devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to study Russian language?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about discoveries in physics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to help others in homework?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the experiments from the field of genetics?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design or analyze technical projects?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to go to the theatre?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to be guided in life logical thinking?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to tell children stories?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to make parts of the model cars, ships, aircraft, etc.?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to grow plants?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about modern technologies?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to perform small repairs in the house?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read magazines about life?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to learn the history of the world?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like studying science?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give others support in difficult situations?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to visit the technical exhibition?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to participate in contests, competitions, historical?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to read about computer programs?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to fix different devices?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to give commands?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to motivate others to work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to support others in difficult times?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to design the interior design?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like remove minor accident?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to manage other people's work?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to draw?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you hold classes?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to write articles?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to plan trips?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to care for the sick?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 2), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }

                {
                    Question q = questionRepository.findByTitle("Do you like to take pictures?");
                    QuestionOption qo1 = q.getQuestionOptions().get(0), qo2 = q.getQuestionOptions().get(1);
                    CourseQuestion cq = new CourseQuestion(c, q);
                    courseQuestionRepository.save(cq);
                    List<CourseQuestionOption> cqos = Arrays.asList(new CourseQuestionOption(cq, qo1, 0), new CourseQuestionOption(cq, qo2, 0));
                    courseOptionRepository.save(cqos);
                    cq.setCourseQuestionOptions(cqos);
                    courseQuestionRepository.save(cq);
                }
            }
        };
    }
}
