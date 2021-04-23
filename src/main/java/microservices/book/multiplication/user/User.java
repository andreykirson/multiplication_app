package microservices.book.multiplication.user;

/**
 * @author Andrey
 * @version 1
 * 4/20/2021
 * multiplication
 */

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String alias;
}
