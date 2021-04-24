package microservices.book.multiplication.challenge;


/**
 * @author Andrey
 * Identifies the attempt from a {@link User} to solve a challenge
 * 4/20/2021
 * multiplication
 */

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
    private Long id;
    private Long userId;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}
