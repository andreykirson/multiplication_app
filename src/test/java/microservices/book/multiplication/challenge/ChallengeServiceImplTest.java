package microservices.book.multiplication.challenge;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.BDDAssertions.then;


class ChallengeServiceImplTest {

    private ChallengeService challengeService;


    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl();
    }


    @Test
    public void checkCorrectAttemptTest() {

        // given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
        // when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isTrue();
    }

    @Test
    public void checkFalseAttemptTest() {
        // given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 200);
        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isFalse();
    }

}