package ir.smartpath.service;

import ir.smartpath.entity.Person;

import java.util.List;

public interface IPersonService {

    Person save(Person person);

    Person getById(Long id);

    Person getByNationalCode(String nationalCode, String password);

    List<Person> getAll();
}
