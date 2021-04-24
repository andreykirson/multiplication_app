package microservices.book.multiplication.dao;

import microservices.book.multiplication.challenge.ChallengeAttempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface ChallengeAttemptRepository extends CrudRepository <ChallengeAttempt, Long> {
    /**
     * @return the last 10 attempts for a given user, identified by their alias.
     */
    @Query("SELECT a FROM ChallengeAttempt a WHERE a.user.alias = ?1 ORDER BY a.id DESC")
    List<ChallengeAttempt> findTop10ByUserAliasOrderByIdDesc(String userAlias);
}
