package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

import java.util.HashMap;

/* 
    database class which will store all the registered user 
*/
public class Database {
    
    private HashMap<String, User> users = new HashMap<>();

    // method to add user in database
    public void addUser(User newUser) {
        users.put(newUser.getEmail(), newUser);
    }

    // method to get user object based on usrname
    public User getUser(String email) {
        return users.get(email);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
