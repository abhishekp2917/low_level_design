package BehaviouralPattern.ObserverPattern.example2.Solution;

import java.util.HashMap;

/*
    ChatApp class will have multiple chat rooms and users and this chat rooms will have
    multiple users     
*/
public class ChatApp {
    
    private String name;
    // map to store all the chat rooms
    private HashMap<Integer, ChatRoom> chatRooms = new HashMap<>();
    // map to store users
    private HashMap<Integer, User> users = new HashMap<>();

    public ChatApp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    // method to create chatRoom in this application
    public void createChatRoom(ChatRoom chatRoom) {
        chatRooms.put(chatRoom.getChatRoomId(), chatRoom);
    }

    // method to create user in this application
    public void createUsers(User user) {
        users.put(user.getUserId(), user);
    }

    // method to add user in chatRoom in this application
    public void addUserToChatRoom(int chatRoomId, int userId) {
        users.get(userId).joinChatRoom(chatRooms.get(chatRoomId));
    }
}
