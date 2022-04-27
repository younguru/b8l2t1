package ru.netology.b8l2t1.Service;

import org.springframework.stereotype.Service;
import ru.netology.b8l2t1.Utils.Authorities;
import ru.netology.b8l2t1.Exception.InvalidCredentials;
import ru.netology.b8l2t1.Exception.UnauthorizedUser;
import ru.netology.b8l2t1.Repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService() {
        this.userRepository = new UserRepository();
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}