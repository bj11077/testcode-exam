package nn.exam.user;

import nn.exam.user.builder.TestDateBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

// Mockito 예제
class UserServiceRefactorTest {


/**
  1. Mock과 service를 테스트 시작시점에 생성
  2. Builder 클래스를 하나 생성해서 테스트데이터 생성을 편하게함
 */

    private UserService userService;

    private UserRepository repository= Mockito.mock(UserRepository.class);

    @BeforeEach
    public void beforeJob(){
        userService = new UserService(repository);
    }

    // mockito로 가짜 클래스만들어서 주입
    @Test
    public void mockSampleSaveTest(){
        //given


        UserDto dto = new UserDto(null,"john",
                20,"health",null,null);

        //when
        userService.save(dto);
    }


    // mockito + 가짜 데이터넣고  반환받기
    @Test
    public void mockAdvanceSaveTest(){
        //given
        UserDto dto = new UserDto(null,"john",
                20,"health",null,null);

        // builder
        User mockReutnEntity = TestDateBuilder.mockBuilder()
                .id(1L)
                .name("john")
                .age(20)
                .hobby("health")
                .build();



        // 어떤값이오든 mockReutnEntity값이 반환되게함
        Mockito.when(repository.save(Mockito.any())).thenReturn(mockReutnEntity);


        //when
        userService.save(dto);

        //실행횟수 따짐
        Mockito.verify(repository,Mockito.timeout(1)).save(Mockito.any());

    }

    //mock data 가짜데이터 return 받기 2번째
    @Test
    public void mockAdvanceFindAllTest(){
        //given

        User mockReutnEntity = TestDateBuilder.mockBuilder()
                .id(1L)
                .name("john")
                .age(20)
                .hobby("health")
                .build();


        //findall하면 해당데이터 반환하게함
        Mockito.when(repository.findAll()).thenReturn(List.of(mockReutnEntity));


        //when
        List<UserDto> result = userService.findAll();

        //실행횟수 따짐
        Mockito.verify(repository,Mockito.timeout(1)).findAll();

        // 동일리스트 점검
        Assertions.assertIterableEquals(List.of(new UserDto(mockReutnEntity)),result);
    }



    // mockito + 가짜 데이터넣고  Captor를 통해 검증
    @Test
    public void mockArgCaptorSaveTest(){
        //given
        UserRepository repository = Mockito.mock(UserRepository.class);

        UserService userService = new UserService(
                repository
        );


        UserDto dto = new UserDto(null,"john",
                20,"health",null,null);

        User mockReutnEntity = TestDateBuilder.mockBuilder()
                .id(1L)
                .name("john")
                .age(20)
                .hobby("health")
                .build();

        //
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);


        // 어떤값이오든 mockReutnEntity값이 반환되게함
        Mockito.when(repository.save(Mockito.any())).thenReturn(mockReutnEntity);


        //when
        UserDto save = userService.save(dto);

        //실행횟수 따짐
//        Mockito.verify(repository,Mockito.timeout(1)).save(Mockito.any());
        Mockito.verify(repository,Mockito.timeout(1)).save(userArgumentCaptor.capture());

        //후에 검증할때 값 활용할 수 있음
        Assertions.assertEquals(userArgumentCaptor.getValue().getAge(),save.age());
    }


}