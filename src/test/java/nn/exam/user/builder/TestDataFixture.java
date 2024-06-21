package nn.exam.user.builder;

import nn.exam.user.User;

import java.time.LocalDateTime;

public class TestDataFixture {

    /**
     * 쓰는이유
     *  1. 특정조건이 달려있는 테스트코드 작성을 위해 사용
     *  2. ex) 성인에게 추가요금이 붙는 테스트일때 나이를 20으로 고정하면 성인이므로 더편해짐
     *  3. 강의에서 builder가 아닌 만들어진 객체로 넘김
     */

    public static User adultUser(){
        return User.builder()
                .id(1L)
                .age(20)
                .name("")
                .hobby("book")
                .registTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }

    public static User notAdultUser(){
        return User.builder()
                .id(1L)
                .age(10)
                .name("")
                .hobby("book")
                .registTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }


}
