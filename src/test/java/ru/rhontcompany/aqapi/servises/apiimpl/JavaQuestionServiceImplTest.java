package ru.rhontcompany.aqapi.servises.apiimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rhontcompany.aqapi.servises.api.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    @Mock
    QuestionRepository javaRepositoryMock;

    @InjectMocks
    JavaQuestionServiceImpl javaQ;


    private final Question TEMP_Q=new Question("test","test");
    private final Question TEMP_Q_2=new Question("test","another");

    Question temp_q=new Question("one","two");

    @BeforeEach
    void setUp() {
        Set<Question> tempSet=new HashSet<>(Set.of(
                new Question("1q","1a"),
                new Question("2q","2a"),
                new Question("3q","3a"),
                new Question("4q","4a"),
                new Question("5q","5a"),
                new Question("6q","6a"),
                new Question("7q","7a")
        ));

        when(javaRepositoryMock.getAll()).thenReturn(tempSet);
    }

    @Test
    void remove() {

    }

    @Test
    void add() {
        when(javaRepositoryMock.add(any())).thenReturn(TEMP_Q);
        assertEquals(TEMP_Q,javaQ.add(TEMP_Q));
    }

    @Test
    void testAdd() {
    }

    @Test
    void getRandomQuestion() {
        temp_q=javaQ.getRandomQuestion();
        assertTrue(javaQ.getAll().contains(temp_q));
    }
}