package BehaviouralPattern.ObserverPattern.example2.Solution;


/*
    Message class wchich will have all the info about message, sender and receiver
*/

public class Message {
    
    private String message;
    private User sender;
    private ChatRoom receiver;
    
    public Message(String message, User sender, ChatRoom receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public User getSender() {
        return this.sender;
    }

    public ChatRoom getReceiver() {
        return this.receiver;
    }
}
