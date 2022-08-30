package ir.smartpath.service;

import ir.smartpath.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {

    Person save(Person person);
    Person getById(Long id);
    List<Person> getAll();

}
