package ir.smartpath.Mapper;

import ir.smartpath.dto.PersonDto;
import ir.smartpath.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDto personDto);

    PersonDto toPersonDTO(Person person);

    List<PersonDto> toPersonDTO(List<Person> personList);

    List<Person> toPerson(List<PersonDto> personDtos);


}
