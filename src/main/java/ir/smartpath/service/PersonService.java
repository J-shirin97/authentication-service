package ir.smartpath.service;


import ir.smartpath.entity.Person;
import ir.smartpath.repository.PersonRepository;
import ir.smartpath.utils.FibonacciAlgorithm;
import ir.smartpath.utils.PasswordManager;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@CacheConfig(cacheNames = {"number"})
public class PersonService implements IPersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final PasswordManager passwordManager;
    private final FibonacciAlgorithm fibonacciAlgorithm;


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


    @Cacheable
    public int getNumber(int number) {
        LOG.info("Fibonacci{}",number);
        return fibonacciAlgorithm.calc(number);
    }
}

