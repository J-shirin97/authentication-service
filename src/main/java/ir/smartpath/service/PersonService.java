package ir.smartpath.service;


import ir.smartpath.entity.Person;
import ir.smartpath.entity.Role;
import ir.smartpath.repository.PersonRepository;
import ir.smartpath.repository.RoleRepository;
import ir.smartpath.utils.FibonacciAlgorithm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"number"})
public class PersonService implements IPersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final FibonacciAlgorithm fibonacciAlgorithm;

    @Override
    public Person save(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        person.setActive(true);
        Role role = roleRepository.findByRole("Admin");
        person.setRoles(new HashSet<>(Collections.singletonList(role)));
        return personRepository.save(person);
    }
    @Override
    public Person findPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public Person findPersonByNationalCode(String nationalCode) {
        return personRepository.findByNationalCode(nationalCode);
    }

    @Cacheable
    public int getNumber(int number) {
        LOG.info("Fibonacci{}", number);
        return fibonacciAlgorithm.calc(number);
    }


}


