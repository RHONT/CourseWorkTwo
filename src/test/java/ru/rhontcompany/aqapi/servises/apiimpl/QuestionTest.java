package ru.rhontcompany.aqapi.servises.apiimpl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    public static void main(String[] args) {
        Set<Question> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Question q1 = new Question("1", "2");
        Question q2 = new Question("1", "10");

        set.add(q1);
        set.add(q2);

        Integer str1 = new Integer("1");
        Integer str2 = new Integer("1");


        set2.add(str1);
        set2.add(str2);

        System.out.println();

        Map<Integer, Integer> map1 = new HashMap<>();


        map1.put(str1, 555);
        map1.put(str2, 555);
        System.out.println();


        System.out.println(set);

    }


}