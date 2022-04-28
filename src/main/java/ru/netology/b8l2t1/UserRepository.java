package ru.netology.b8l2t1;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private class userParameters {
        public String password;
        public List<Authorities> authorities;

        public userParameters(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }
    }

    private Map<String, userParameters> users;

    public UserRepository() {
        users = new HashMap<>();
        users.put("Vasya", new userParameters("1234", List.of(Authorities.READ, Authorities.WRITE)));
        users.put("Petya", new userParameters("3344", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("Kolya", new userParameters("3456", List.of(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (password.equals(users.get(user).password)) {
            return users.get(user).authorities;
        }
        return null;
    }
}