package microservices.book.multiplication.challenge;

/**
 * @author Andrey
 * 4/20/2021
 * multiplication
 */


public interface ChallengeGeneratorService {

    /**
     * @return a randomly-generated challenge with factors between 11 and 99
     */
    Challenge randomChallenge();

}
