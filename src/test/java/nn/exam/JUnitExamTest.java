package nn.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JUnitExamTest {


    @Test
    @DisplayName("assertEquals")
    void assertEqual(){
        // 두값이 동일한지 확인
        String expect="a";
        String value="a";
        Assertions.assertEquals(expect,value);
    }

    @Test
    @DisplayName("assertNotEquals")
    void assertNotEqual(){
        // 두값이 동일하지않은지 확인
        String expect = "a";
        String value="b";
        Assertions.assertNotEquals(expect,value);
    }

    @Test
    @DisplayName("assertTrue")
    void assertTrue(){
        // true인지 확인
        boolean value = true;
        Assertions.assertTrue(value);
    }

    @Test
    @DisplayName("assertFalse")
    void assertFalse(){
        // false인지 확인
        boolean value = false;
        Assertions.assertFalse(value);
    }

    @Test
    @DisplayName("assertNull")
    void assertNull(){
        // null인지 확인
        Object value = null;
        Assertions.assertNull(value);
    }

    @Test
    @DisplayName("assertNotNull")
    void assertNotNull(){
        // null이 아닌지 확인
        Object value = "";
        Assertions.assertNotNull(value);
    }

    @Test
    @DisplayName("assertThrows")
    void assertThrows(){
        // 예외가 발생하는지 확인
        Assertions.assertThrows(RuntimeException.class,() -> {
            throw new RuntimeException("");}
        );
    }

    @Test
    @DisplayName("assertIterableEquals")
    void assertIterableEquals(){
        // 리스트 요소가 동일한지 확인
        List<String> expect = List.of("a", "b", "c");
        List<String> value = List.of("a", "b", "c");
        Assertions.assertIterableEquals(expect,value);
    }

    @Test
    @DisplayName("assertAll")
    void assertAll(){

        Object value1 = "";
        String expect2="";
        String value2="";

        //모든 assert가 맞는지 확인
        Assertions.assertAll("heading",List.of(
                ()-> {Assertions.assertNotNull(value1);},
                ()->{Assertions.assertEquals(expect2,value2);}
        ));

    }







}
