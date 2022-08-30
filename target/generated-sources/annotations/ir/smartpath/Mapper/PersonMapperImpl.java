package ir.smartpath.Mapper;

import ir.smartpath.dto.PersonDto;
import ir.smartpath.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-30T19:59:41+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setFirstName( personDto.getFirstName() );
        person.setLastName( personDto.getLastName() );
        person.setNationalCode( personDto.getNationalCode() );
        person.setAge( personDto.getAge() );
        person.setGender( personDto.getGender() );
        person.setEmail( personDto.getEmail() );
        person.setPassword( personDto.getPassword() );

        return person;
    }

    @Override
    public PersonDto toPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setFirstName( person.getFirstName() );
        personDto.setLastName( person.getLastName() );
        personDto.setNationalCode( person.getNationalCode() );
        personDto.setAge( person.getAge() );
        personDto.setGender( person.getGender() );
        personDto.setEmail( person.getEmail() );
        personDto.setPassword( person.getPassword() );

        return personDto;
    }

    @Override
    public List<PersonDto> toPersonDTO(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( personList.size() );
        for ( Person person : personList ) {
            list.add( toPersonDTO( person ) );
        }

        return list;
    }

    @Override
    public List<Person> toPerson(List<PersonDto> personDtos) {
        if ( personDtos == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( personDtos.size() );
        for ( PersonDto personDto : personDtos ) {
            list.add( toPerson( personDto ) );
        }

        return list;
    }
}
