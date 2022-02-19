package me.patrick.laboratory.testrepeat;

import me.patrick.laboratory.finalvalue.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRepeat {

    @DisplayName("테스트")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void test(RepetitionInfo repetitionInfo){
        System.out.println("순차 테스트 " + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("인덱스 파라미터")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"Hello", "World"})
    void test(String a){
        System.out.println(a);
    }

    @DisplayName("인덱스 파라미터")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"Hello", "World"})
  /*  @EmptySource
    @NullSource*/
    @NullAndEmptySource
    void testFurther(String a){
        System.out.println(a);
    }

    @DisplayName("인덱스 파라미터")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"java","10",""})
  /*  @EmptySource
    @NullSource*/
    @NullAndEmptySource
    void cvsSourceTest(String a){
        System.out.println(a);
    }

    @DisplayName("인덱스 파라미터")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20,30})
    void testSimpleArgument(@ConvertWith(SimpleArgument.class) MemberDto memberDto){
        System.out.println(memberDto.getAge());
    }

    @DisplayName("인덱스 파라미터")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"'자바스터디',10"})
    void testCVSSimpleArgument(@ConvertWith(SimpleArgument.class) MemberDto memberDto){
        System.out.println(memberDto.getAge());
    }

    static class SimpleArgument extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(MemberDto.class, targetType,"Can only convert to MemberDto");
            return new MemberDto(Integer.parseInt(source.toString()));
        }
    }

}
