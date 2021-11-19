package ru.geekbrains.java2.lessons.lesson7;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class AutenticationService {

    private static final Set<User> users = Set.of(
            new User("User1", "l1", "p1"),
            new User("User2", "l2", "p2"),
            new User("User3", "l3", "p3")
    ); // Статическое свойство


    public Optional<String> findUserNameByLoginAndPassword(String login, String password) {


// for (User user: users) {
//     if(user.getLogin().equals(login) && user.getPassword().equals(password)){
//         return Optional.of(user.getUsername());
//     }
//  }
//  return Optional.empty();

        return users.stream()   //Stream это обертка коллекции
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))//filter это выполнение условия
                .findFirst().map(User::getUsername);
    }// метод для аутентификации


    private static class User {
        private String username;
        private String login;
        private String password;

        public User(String username, String login, String password) {
            this.username = username;
            this.login = login;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username) && Objects.equals(login, user.login) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, login, password);
        }
    }

}
