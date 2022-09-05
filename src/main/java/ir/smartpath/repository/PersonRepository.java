package ir.smartpath.repository;

import ir.smartpath.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByNationalCodeAndPassword(String nationalCode, String password);

    Person findByNationalCode(String nationalCode);

    Person findByEmail(String email);

}
