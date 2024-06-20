package nn.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class JUnitReapeatableTest {


    //같은테스트를 (5) 회 반복
    @RepeatedTest(5)
    @DisplayName("assertEquals")
    void assertEqual(){
        // 두값이 동일한지 확인
        String expect="a";
        String value="a";
        Assertions.assertEquals(expect,value);
    }


    // 파라미터를 줄수있음
    // MethodSource 내부에 파라미터 정의한 메소드명 등록
    @ParameterizedTest
    @MethodSource("parameterizedTestParameters")
    public void parameterizedTest(Double value, Double expect){

        System.out.println("value: "+value);
        System.out.println("expect: "+expect);
        Assertions.assertEquals(value,expect);
    }


    //파라미터값 정의
    public static Stream<Arguments> parameterizedTestParameters(){
        return Stream.of(
                Arguments.of(10.0,10.0),
                Arguments.of(8.0,8.0),
                Arguments.of(4.0,4.0),
                Arguments.of(16.0,16.0),
                Arguments.of(17.0,17.0)
        );
    }



}
