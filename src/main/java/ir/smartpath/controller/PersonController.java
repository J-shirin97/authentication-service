package ir.smartpath.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ir.smartpath.Mapper.PersonMapper;
import ir.smartpath.dto.PersonDto;
import ir.smartpath.entity.Person;
import ir.smartpath.service.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final IPersonService personService;
    private final PersonMapper personMapper;


    @PostMapping("/v1")
    public ResponseEntity<Void> saveNew(@RequestBody PersonDto personDto) {
        Person person = personMapper.toPerson(personDto);
        personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Long id) {
        Person person = personService.getById(id);
        PersonDto personDto = personMapper.toPerosnDTO(person);
        return ResponseEntity.ok(personDto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<PersonDto>> getAll() {
        List<Person> personList = personService.getAll();
        List<PersonDto> personDtoList = personMapper.toPersonDTO(personList);
        return ResponseEntity.ok(personDtoList);

    }
}
