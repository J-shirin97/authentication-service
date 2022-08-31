package ir.smartpath.repository;

import ir.smartpath.entity.Person;
import ir.smartpath.utils.FibonacciAlgorithm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByNationalCodeAndPassword(String nationalCode, String password);
}
