package by.bsu.diploma.authentication.controller;

import by.bsu.diploma.authentication.service.UserService;
import by.bsu.diploma.commons.domain.Enrollee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping
    public void createUser(@Valid @RequestBody Enrollee enrollee) {
        userService.create(enrollee);
    }
}
