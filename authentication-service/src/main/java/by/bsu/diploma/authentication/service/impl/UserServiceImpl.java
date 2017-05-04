package by.bsu.diploma.authentication.service.impl;

import by.bsu.diploma.authentication.repository.EnrolleeRepository;
import by.bsu.diploma.authentication.service.UserService;
import by.bsu.diploma.commons.domain.Enrollee;
import by.bsu.diploma.commons.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private EnrolleeRepository enrolleeRepository;

    @Transactional
    @Override
    public void create(Enrollee enrollee) {
        Optional<Enrollee> foundEnrollee = enrolleeRepository.findByEmail(enrollee.getEmail());
        if(foundEnrollee.isPresent()) {
            throw new ValidationException("User with such email already exists: " + enrollee.getEmail());
        }

        enrollee.setPassword(ENCODER.encode(enrollee.getPassword()));

        enrolleeRepository.save((Enrollee) enrollee);
    }
}
