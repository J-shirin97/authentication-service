package ir.smartpath.Mapper;

import ir.smartpath.dto.PersonDTO;
import ir.smartpath.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDTO personDto);

    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTO(List<Person> personList);

    List<Person> toPerson(List<PersonDTO> personDTOS);


}
