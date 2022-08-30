package ir.smartpath.service;


import ir.smartpath.entity.Person;
import ir.smartpath.repository.PersonRepository;
import ir.smartpath.utils.PasswordManager;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;
    private final PasswordManager passwordManager;


    @Override
    public Person save(Person person) {
        char[] passwordChars = person.getPassword().toCharArray();
        byte[] saltBytes = person.getNationalCode().getBytes();
        byte[] hashedBytes = passwordManager.hashPassword(passwordChars, saltBytes, 10_000, 512);
        person.setPassword(Hex.encodeHexString(hashedBytes));
        return personRepository.save(person);
    }

    @Override
    public Person getById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (!optionalPerson.isPresent()) {
            //
        }

        return optionalPerson.get();

    }

    @Override
    public Person getByNationalCode(String nationalCode, String password) {
        try {
            Person person = personRepository.findByNationalCodeAndPassword(nationalCode, password);
            char[] passwordChars = person.getPassword().toCharArray();
            byte[] saltBytes = person.getNationalCode().getBytes();
            byte[] hashedBytes = passwordManager.hashPassword(passwordChars, saltBytes, 10_000, 512);
            String hashedString = Hex.encodeHexString(hashedBytes);
            if (nationalCode.equals(person.getNationalCode()) && hashedString.equals(person.getPassword())) {
                return person;
            } else {
                return null;
            }
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }



}
