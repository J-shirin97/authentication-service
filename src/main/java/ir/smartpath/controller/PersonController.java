package ir.smartpath.controller;


import ir.smartpath.entity.Person;
import ir.smartpath.service.IPersonService;
import ir.smartpath.utils.FibonacciAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final IPersonService personService;


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @GetMapping("/register")
//    public ModelAndView registration(@PathVariable Person person) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("person", person);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }

    @PostMapping("/register")
    public ModelAndView createNewPerson(@RequestBody @Valid Person person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Person personExist = personService.findPersonByNationalCode(person.getNationalCode());
        if (personExist != null) {
            bindingResult.rejectValue("nationalCode", "error.user"
                    , "There is already a user register with the user name provided.");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            personService.save(person);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("person", new Person());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    @GetMapping("/fibo/home")
    public ModelAndView fibo(@PathVariable Integer number) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Person person = personService.findPersonByNationalCode(auth.getName());
        modelAndView.addObject("username", "welcome " + person.getNationalCode() + "/" + person.getFirstName()
                + " " + person.getLastName() + " (" + person.getEmail() + ")");
        modelAndView.setViewName("fibo/home");
        return modelAndView;
    }

    @PostMapping("/calc")
    public int calc(@RequestBody int number) {
        return new FibonacciAlgorithm().calc(number);
    }
}




