package ir.smartpath.controller;

import ir.smartpath.Mapper.PersonMapper;
import ir.smartpath.dto.LoginDTO;
import ir.smartpath.dto.PersonDTO;
import ir.smartpath.entity.Person;
import ir.smartpath.service.IPersonService;
import ir.smartpath.utils.FibonacciAlgorithm;
import ir.smartpath.utils.PasswordManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/Person")
@AllArgsConstructor
public class PersonController {
    private final IPersonService personService;
    private final PersonMapper personMapper;
    private final PasswordManager passwordManager;
    private final FibonacciAlgorithm fibonacciAlgorithm;

    @PostMapping("/PersonSave")
    public ResponseEntity<Void> saveNew(@RequestBody PersonDTO personDto) {
        Person person = personMapper.toPerson(personDto);
        personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/UserLogin")
    public ResponseEntity<Void> login(@RequestBody LoginDTO loginDTO, HttpSession httpSession) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/GetById/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        Person person = personService.getById(id);
        PersonDTO personDto = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(personDto);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<Person> personList = personService.getAll();
        List<PersonDTO> personDTOList = personMapper.toPersonDTO(personList);
        return ResponseEntity.ok(personDTOList);
    }

    @GetMapping("/FibonacciAlgorithm")
    public int fib(int number) {
        return fibonacciAlgorithm.calc(number);
    }
}


