package BehaviouralPattern.ObserverPattern.example2.Solution;

import java.util.HashMap;


/* 
    User class who can join multiple chat rooms and can send message in that chat room
*/
public class User {
    
    private String userName;
    private int userId;
    private HashMap<Integer, ChatRoom> chatRooms = new HashMap<>();

    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public HashMap<Integer, ChatRoom> getChatRooms() {
        return chatRooms;
    }

    // method to join a particular chat room
    public void joinChatRoom(ChatRoom chatRoom) {
        chatRoom.addMember(this);
        this.chatRooms.put(chatRoom.getChatRoomId(), chatRoom);
    }
    
    // method to send message in the chat room
    public void sendMessage(Message message) {
        chatRooms.get(message.getReceiver().getChatRoomId()).showMessage(message);
    }

    // method to get update or notification of any new message in the chat room
    public void update(Message message) {
        System.out.println("Hey " + this.userName + "! " + message.getSender().getUserName() + " has sent message:");
        System.out.println(message.getMessage() + "\n");
    }
}
