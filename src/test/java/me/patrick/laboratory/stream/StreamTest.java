package me.patrick.laboratory.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

    @Test
    @DisplayName("외부변수 사용 테스트")
    void outerValueTest() {

        final Integer changeAge = 30;

        List<PersonStreamTest> personStreamTestList = Arrays.asList(
                new PersonStreamTest("홍지운",31),
                new PersonStreamTest("유호연",33)
        );

        personStreamTestList.forEach(personStreamTest -> personStreamTest.changeAge(changeAge));

    }


    public static class PersonStreamTest {

        private final String name;
        private Integer age;

        public PersonStreamTest(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public void changeAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
