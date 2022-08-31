package ir.smartpath.Mapper;

import ir.smartpath.dto.PersonDTO;
import ir.smartpath.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T22:29:01+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toPerson(PersonDTO personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setVersion( personDto.getVersion() );
        person.setCreatedDate( personDto.getCreatedDate() );
        person.setCreatedBy( personDto.getCreatedBy() );
        person.setLastModifiedDate( personDto.getLastModifiedDate() );
        person.setLastModifiedBy( personDto.getLastModifiedBy() );
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
    public PersonDTO toPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setVersion( person.getVersion() );
        personDTO.setCreatedDate( person.getCreatedDate() );
        personDTO.setCreatedBy( person.getCreatedBy() );
        personDTO.setLastModifiedDate( person.getLastModifiedDate() );
        personDTO.setLastModifiedBy( person.getLastModifiedBy() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setNationalCode( person.getNationalCode() );
        personDTO.setAge( person.getAge() );
        personDTO.setGender( person.getGender() );
        personDTO.setEmail( person.getEmail() );
        personDTO.setPassword( person.getPassword() );

        return personDTO;
    }

    @Override
    public List<PersonDTO> toPersonDTO(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( personList.size() );
        for ( Person person : personList ) {
            list.add( toPersonDTO( person ) );
        }

        return list;
    }

    @Override
    public List<Person> toPerson(List<PersonDTO> personDTOS) {
        if ( personDTOS == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( personDTOS.size() );
        for ( PersonDTO personDTO : personDTOS ) {
            list.add( toPerson( personDTO ) );
        }

        return list;
    }
}