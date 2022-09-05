package ir.smartpath.service;

import ir.smartpath.entity.Person;

public interface IPersonService {

    Person save(Person person);

/*    Person getByNationalCode(String nationalCode, String password);*/

    Person findPersonByEmail(String email);

    Person findPersonByNationalCode(String nationalCode);

}
