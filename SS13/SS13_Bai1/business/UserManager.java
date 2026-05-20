package SS13_Bai1.business;

import SS13_Bai1.model.Person;
import java.util.LinkedList;
import java.util.List;

public class UserManager {
    private final List<Person> userList = new LinkedList<>();

    public void addUser(Person person) {
        userList.add(person);
    }

    public boolean deleteUserByEmail(String email) {
        return userList.removeIf(person -> person.getEmail().equalsIgnoreCase(email));
    }

    public List<Person> getAllUsers() {
        return userList;
    }
}