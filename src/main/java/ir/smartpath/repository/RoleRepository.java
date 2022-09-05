package ir.smartpath.repository;

import ir.smartpath.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByRole(String role);
}
