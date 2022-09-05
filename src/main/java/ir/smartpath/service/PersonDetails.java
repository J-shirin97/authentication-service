package ir.smartpath.service;

import ir.smartpath.entity.Person;
import ir.smartpath.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonDetails implements UserDetailsService {
    private final PersonService personService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nationalCode) throws UsernameNotFoundException {
        Person person = personService.findPersonByNationalCode(nationalCode);
        List<GrantedAuthority> authorities = getPersonAuthority(person.getRoles());
        return buildPersonForAuthentication(person, authorities);
    }

    private List<GrantedAuthority> getPersonAuthority(Set<Role> personRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : personRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildPersonForAuthentication(Person person, List<GrantedAuthority> authorities) {
        return new User(person.getNationalCode(), person.getPassword(), person.getActive(), true, true, true, authorities);
    }
}
