package ru.rhontcompany.aqapi.servises.apiimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rhontcompany.aqapi.constatnt.Constants;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.rhontcompany.aqapi.constatnt.Constants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    private final QuestionRepository javaRepositoryMock = mock(JavaQuestionRepositoryImpl.class);

    JavaQuestionServiceImpl javaQ;

    Question temp_q = new Question("one", "two");

    @BeforeEach
    void setUp() {
        javaQ = new JavaQuestionServiceImpl(javaRepositoryMock);

        Set<Question> tempSet = new HashSet<>(Set.of(
                new Question("1q", "1a"),
                new Question("2q", "2a"),
                new Question("3q", "3a"),
                new Question("4q", "4a"),
                new Question("5q", "5a"),
                new Question("6q", "6a"),
                new Question("7q", "7a")
        ));

        when(javaRepositoryMock.getAll()).thenReturn(tempSet);
    }

    @Test
    void remove() {
        when(javaRepositoryMock.remove(TEMP_Q)).thenReturn(TEMP_Q);
        assertEquals(TEMP_Q, javaQ.remove(TEMP_Q));
    }

    @Test
    void add() {
        when(javaRepositoryMock.add(any())).thenReturn(TEMP_Q);
        assertEquals(TEMP_Q, javaQ.add(TEMP_Q));

    }

    // сомневаюсь в этом тесте
    // ведь тут не идет проверка, а просто подставляется желаемое значение...
    @Test
    void add_Erase_Duplicate_Question() {
        when(javaRepositoryMock.add(TEMP_Q)).thenReturn(TEMP_Q);
        when(javaRepositoryMock.add(TEMP_Q_2)).thenReturn(TEMP_Q_2);
        javaQ.add(TEMP_Q);
        assertEquals(TEMP_Q_2, javaQ.add(TEMP_Q_2));
    }

    @Test
    void getRandomQuestion() {
        temp_q = javaQ.getRandomQuestion();
        assertTrue(javaQ.getAll().contains(temp_q));
    }

    @Test
    public void add_Throw_IllegalArgumentException() {
        when(javaRepositoryMock.add("", "")).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> javaQ.add("", ""));
    }
}