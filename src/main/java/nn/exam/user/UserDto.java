package nn.exam.user;

import java.time.LocalDateTime;

public record UserDto(Long id, String name, Integer age, String hobby, LocalDateTime registTime, LocalDateTime updateTime) {

    public UserDto(User user){
      this  (user.getId(),user.getName(),user.getAge(),
              user.getHobby(), user.getRegistTime(), user.getUpdateTime());
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .age(age)
                .hobby(hobby)
                .registTime(registTime)
                .updateTime(updateTime).build();
    }
}
