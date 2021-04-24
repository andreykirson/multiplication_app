package microservices.book.multiplication.service;

import microservices.book.multiplication.challenge.ChallengeAttempt;
import microservices.book.multiplication.challenge.ChallengeAttemptDTO;

import java.util.List;

public interface ChallengeService {

    /**
     * Verifies if an attempt coming from the presentation layer is correct or not.
     @return the resulting ChallengeAttempt object
     */
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);

    /**
     * Gets the statistics for a given user.
     * *
     @param userAlias the user's alias
      * @return a list of the last 10 {@link ChallengeAttempt}
     * objects created by the user.
     */
    List<ChallengeAttempt> getStatsForUser(String userAlias);
}
