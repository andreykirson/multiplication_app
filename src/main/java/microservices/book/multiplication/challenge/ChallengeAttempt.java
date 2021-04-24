package microservices.book.multiplication.challenge;


/**
 * @author Andrey
 * Identifies the attempt from a {@link User} to solve a challenge
 * 4/20/2021
 * multiplication
 */


import lombok.*;
import microservices.book.multiplication.user.User;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
    @Id
    @GeneratedValue
    private Long id;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
}
