package ru.rhontcompany.aqapi.servises.apiimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rhontcompany.aqapi.exception.StopedMathRepository;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathQuestionServiceImplTest {

    private final Question TEMP_Q = new Question("test", "test");
    private final Question TEMP_Q_2 = new Question("test", "another");

    private MathQuestionServiceImpl math;

    @BeforeEach
    void setUp() {
        math = new MathQuestionServiceImpl(new Random());
        math.setActive(true);

    }

    @Test
    public void getRandomQuestion_Add_Two_Random_Element() {
        math.getRandomQuestion();
        math.getRandomQuestion();
        assertEquals(2, math.getAll().size());
    }


    @Test
    public void remove() {
        math.getRandomQuestion();
        math.getRandomQuestion();
        math.add(TEMP_Q);
        assertEquals(3, math.getAll().size());
        math.remove(TEMP_Q);
        assertEquals(2, math.getAll().size());

    }

    @Test
    public void add_Erase_Duplicate_Question() {
        math.add(TEMP_Q);
        math.add(TEMP_Q_2);
        assertEquals(TEMP_Q_2, math.getAll().stream().findFirst().get());

    }

    @Test
    public void add_Throw_StopedMathRepository() {
        math.setActive(false);
        assertThrows(StopedMathRepository.class, () -> math.add(TEMP_Q));
    }
}