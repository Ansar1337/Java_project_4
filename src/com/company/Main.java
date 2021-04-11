package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        //TODO Проверить логин и пароль
        User user = getUserByLoginAndPassword(login, password);
        System.out.println("User: " + user.getLogin() + " - " + user.getEmail());

        //TODO Вызвать методы валидации пользователя
        validateUser(user);
        System.out.println("Access granted");
    }

    public static User[] getUsers() {
        User user1 = new User("john", "john@gmail.com", "pass", 17);
        User user2 = new User("mike", "mike@gmail.com", "qwerty", 18);
        User user3 = new User("steve", "steve@gmail.com", "asdfg", 23);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsersList();
        for (User user : users) {
            if (login.equalsIgnoreCase(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found: " + login);
    }

    private static User[] getUsersList() {
        return getUsers();
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Access Denied");
        } else {
            getUsers();
        }
    }
}