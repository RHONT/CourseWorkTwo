package ru.rhontcompany.aqapi.servises.apiimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rhontcompany.aqapi.servises.api.QuestionService;
import static ru.rhontcompany.aqapi.constatnt.Constants.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

    private final QuestionService math = mock(MathQuestionServiceImpl.class);
    private final QuestionService java = mock(JavaQuestionServiceImpl.class);

    ExamServiceImpl examService;

    @BeforeEach
    void setUp() {
        examService = new ExamServiceImpl(new Random(), new ArrayList<>(List.of(math, java)));

        Set<Question> tempSet = new HashSet<>(Set.of(
                new Question("1q", "1a"),
                new Question("2q", "2a"),
                new Question("3q", "3a"),
                new Question("4q", "4a"),
                new Question("5q", "5a"),
                new Question("6q", "6a"),
                new Question("7q", "7a")
        ));
        when(java.getAll()).thenReturn(tempSet);
        when(math.getRandomQuestion()).thenReturn(TEMP_Q);
        when(java.getRandomQuestion()).thenReturn(TEMP_Q_3);

    }

    @Test
    void getRandomCollect() {
        Set<Question> setTemp=new HashSet<>();
        setTemp.add(TEMP_Q);
        setTemp.add(TEMP_Q_3);

        assertEquals(setTemp,examService.getRandomCollect(2));
    }

    @Test
    void getRandomCollect_Throw_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,()->examService.getRandomCollect(-1));
    }
}