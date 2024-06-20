package nn.exam.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping
    public List<UserDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto dto){
        return service.save(dto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.deleteById(id);
    }



}
