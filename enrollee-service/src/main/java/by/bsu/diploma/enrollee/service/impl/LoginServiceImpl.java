package by.bsu.diploma.enrollee.service.impl;

import by.bsu.diploma.commons.domain.User;
import by.bsu.diploma.enrollee.dto.SignUpRequestContext;
import by.bsu.diploma.enrollee.repository.EnrolleeRepository;
import by.bsu.diploma.enrollee.repository.UserRepository;
import by.bsu.diploma.enrollee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrolleeRepository enrolleeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signUp(SignUpRequestContext signUpRequestContext) {
        Optional<User> userByEmail = userRepository.findByEmail(signUpRequestContext.getEmail());
        if (userByEmail.isPresent()) {
            throw new ValidationException("User with such login already presents: " + signUpRequestContext.getEmail());
        }

        enrolleeRepository.save(signUpRequestContext.toEnrolee(passwordEncoder));
    }

    @Override
    public boolean checkUserIdByLogin(Long id, String login) {
        Optional<User> userOptional = userRepository.findByEmail(login);
        return userOptional.isPresent() && userOptional.get().getId().equals(id);
    }
}
