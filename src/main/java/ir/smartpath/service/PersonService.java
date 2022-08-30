package ir.smartpath.service;


import ir.smartpath.entity.Person;
import ir.smartpath.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;



    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getById(Long id) {
       Optional<Person> optionalPerson = personRepository.findById(id);
       return optionalPerson.get();

    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }
}
