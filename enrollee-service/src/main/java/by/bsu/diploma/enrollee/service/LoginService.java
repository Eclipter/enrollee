package by.bsu.diploma.enrollee.service;

import by.bsu.diploma.enrollee.dto.SignUpRequestContext;

public interface LoginService {
    void signUp(SignUpRequestContext signUpRequestContext);

    boolean checkUserIdByLogin(Long id, String login);
}
