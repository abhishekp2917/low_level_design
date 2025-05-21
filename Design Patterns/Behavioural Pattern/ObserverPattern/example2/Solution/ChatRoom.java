package BehaviouralPattern.ObserverPattern.example2.Solution;

import java.util.ArrayList;
import java.util.List;


/* 
    ChatRoom class which will have multiple user who can send message in this room
    while all the other user will get notification of the message
*/
public class ChatRoom {
    
    private String name;
    private int chatRoomId;
    // list to store all the members of this chat room 
    private List <User> members = new ArrayList<>();
    
    public ChatRoom(String name, int chatRoomId) {
        this.name = name;
        this.chatRoomId = chatRoomId;
    }

    public String getName() {
        return name;
    }

    public int getChatRoomId() {
        return chatRoomId;
    }

    public List<User> getMembers() {
        return members;
    }

    // method to add memeber in this chat room
    public void addMember(User newUser) {
        members.add(newUser);
    }

    // method to show message sent by the user and to notify all the other user
    public void showMessage(Message message) {
        System.out.println(message.getSender().getUserName() + " : \n" + message.getMessage() + "\n");
        broadcastMessage(message);
    }

    /*  method to broadcast or notify the message to all the other members of this chat room
        except the sender itself
    */
    public void broadcastMessage(Message message) {
        for (User member : members) {
            if(!member.equals(message.getSender()))
                member.update(message);
        }
    }
}
