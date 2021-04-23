package microservices.book.multiplication.challenge;

import microservices.book.multiplication.user.User;
import org.springframework.stereotype.Service;

/**
 * @author Andrey
 * 4/21/2021
 * multiplication
 */

@Service
public class ChallengeServiceImpl implements ChallengeService{

    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {

        boolean isCorrect = attemptDTO.getGuess() ==
                attemptDTO.getFactorA() * attemptDTO.getFactorB();

        User user = new User(null, attemptDTO.getUserAlias());

        ChallengeAttempt checkedAttempt = new ChallengeAttempt(null, user.getId(),
                attemptDTO.getFactorA(),
                attemptDTO.getFactorB(),
                attemptDTO.getGuess(),
                isCorrect
        );
        return checkedAttempt;
    }
}
