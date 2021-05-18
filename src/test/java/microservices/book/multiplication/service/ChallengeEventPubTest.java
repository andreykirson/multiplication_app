package microservices.book.multiplication.service;

import microservices.book.multiplication.challenge.ChallengeAttempt;
import microservices.book.multiplication.challenge.ChallengeSolvedEvent;
import microservices.book.multiplication.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;


@ExtendWith({MockitoExtension.class})
class ChallengeEventPubTest {
    private ChallengeEventPub challengeEventPub;

    @Mock
    private AmqpTemplate amqpTemplate;

    @BeforeEach
    public void setUp() {
        challengeEventPub = new ChallengeEventPub(amqpTemplate, "test.topic");
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void sendAttempt(boolean correct) {

        //given
        ChallengeAttempt attempt = createTestAttempt(correct);
        //when
        challengeEventPub.challengeSolved(attempt);
        //then
        var exchangeCaptor = ArgumentCaptor.forClass(String.class);
        var routingKeyCaptor = ArgumentCaptor.forClass(String.class);
        var eventCaptor = ArgumentCaptor.forClass(ChallengeSolvedEvent.class);

        verify(amqpTemplate).convertAndSend(exchangeCaptor.capture(),
                routingKeyCaptor.capture(), eventCaptor.capture());
        then(exchangeCaptor.getAllValues()).isEqualTo("test.topic");
        then(routingKeyCaptor.getAllValues()).isEqualTo("attempt." + (correct ? "correct" : "wrong"));
        then(eventCaptor.getAllValues()).isEqualTo(solvedEvent(correct));
    }

    private ChallengeAttempt createTestAttempt(boolean correct) {
        return new ChallengeAttempt(1L, 30, 40, correct ? 1200:1300, correct, new User(10L, "jhon"));
    }

    private ChallengeSolvedEvent solvedEvent(boolean correct) {
        return new ChallengeSolvedEvent(1L, correct, 30, 40, 10L, "jhon");
    }
}