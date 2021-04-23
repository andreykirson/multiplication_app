package microservices.book.multiplication.challenge;

/**
 * @author Andrey
 * 4/21/2021
 * multiplication
 */

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * Attempt coming from the user
 */

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class ChallengeAttemptDTO {

    @Min(1) @Max(99)
    int factorA, factorB;
    @NotBlank
    String userAlias;
    @Positive(message = "How could you possibly get a negative result here? Try again.")
    int guess;

}
