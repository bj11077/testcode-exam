package nn.exam.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public UserDto findById(Long id){
        return new UserDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    public List<UserDto> findAll(){
      return  repository.findAll().stream().map(UserDto::new).toList();
    }

    public UserDto save(UserDto dto) {
        User save = repository.save(dto.toEntity());
        return new UserDto(save);
    }

    @Transactional(rollbackOn = Exception.class)
    public boolean deleteById(Long id){
        Optional<User> entity = repository.findById(id);
        boolean isExist = entity.isPresent();
        if(isExist)
            repository.delete(entity.get());
        return isExist;
    }


}
