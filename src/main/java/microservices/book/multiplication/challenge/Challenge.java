package microservices.book.multiplication.challenge;

/**
 * @author Andrey
 * 4/20/2021
 * multiplication
 */

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Challenge {
    private int factorA;
    private int factorB;
}
