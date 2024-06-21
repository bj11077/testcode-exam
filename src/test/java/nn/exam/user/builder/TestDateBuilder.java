package nn.exam.user.builder;

import nn.exam.user.User;

import java.time.LocalDateTime;

public class TestDateBuilder {


    public static User.UserBuilder mockBuilder(){
        return User.builder()
                .registTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now());
    }
}
