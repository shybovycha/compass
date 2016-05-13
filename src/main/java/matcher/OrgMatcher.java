package matcher;

import entities.Answer;
import entities.OrgQuestionOption;
import entities.QuestionOption;
import entities.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.OrgQuestionRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by shybovycha on 13/05/16.
 */
@Service
public class OrgMatcher {
    @Autowired
    private OrgQuestionRepository orgQuestionRepository;

    public OrgMatcher() {
    }

    public List<RankedOrgMatch> match(Search search) {
        return StreamSupport
                .stream(orgQuestionRepository.findAll().spliterator(), false)
                .filter(q -> search.getAnswers()
                        .stream()
                        .map(Answer::getQuestion)
                        .anyMatch(aq -> aq.getId() == q.getQuestion().getId()))
                .map(q -> {
                            List<OrgQuestionOption> orgQuestionOptions = q.getOrgQuestionOptions()
                                    .stream()
                                    .filter(o ->
                                            search.getAnswers()
                                                    .stream()
                                                    .filter(a -> a.getQuestion().getId() == q.getQuestion().getId())
                                                    .findFirst()
                                                    .get().getQuestionOptions()
                                                    // these lines below may be replaced with just .contains() use.
                                                    // but it's 3 AM now so i'll leave it here as it is until i get
                                                    // some fresh mind and will to refactor this
                                                    .stream()
                                                    .map(QuestionOption::getId)
                                                    .filter(i -> i == o.getQuestionOption().getId())
                                                    .findFirst()
                                                    .isPresent()
                                    )
                                    .collect(Collectors.toList());

                            Integer w = orgQuestionOptions
                                    .stream()
                                    .map(OrgQuestionOption::getWeight)
                                    .collect(Collectors.summingInt(Integer::intValue));

                            return new RankedOrgMatch(q.getOrg(), w);
                        }
                )
                // this basically perform distinct operation
                .filter(distinctByKey(RankedOrgMatch::getOrg))
                .collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
