package microservices.book.multiplication.challenge;


/**
 * @author Andrey
 * Identifies the attempt from a {@link User} to solve a challenge
 * 4/20/2021
 * multiplication
 */


import lombok.*;
import microservices.book.multiplication.user.User;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
    private Long id;
    private User user;
    // We decided to include factors
// private final int factorA;
// private final int factorB;
// This is an alternative
    private Challenge challenge;
    private int resultAttempt;
    private boolean correct;
}
