package ru.netology.b8l2t1;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private class UserParameters {
        public String password;
        public List<Authorities> authorities;

        public UserParameters(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }
    }

    private Map<String, UserParameters> users;

    public UserRepository() {
        users = new HashMap<>();
        users.put("Vasya", new UserParameters("1234", List.of(Authorities.READ, Authorities.WRITE)));
        users.put("Petya", new UserParameters("3344", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("Kolya", new UserParameters("3456", List.of(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        UserParameters userParameters = users.get(user);
        if (userParameters != null && password.equals(userParameters.password)) {
            return userParameters.authorities;
        }
        return null;
    }
}