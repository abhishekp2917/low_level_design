package BehaviouralPattern.ObserverPattern.example2.Solution;


public class Client1 {
    public static void main(String[] args) {
        
        /* 
            creating chat application named 'WhatsApp' which will have multiple chat rooms
            and users
        */
        ChatApp whatsApp = new ChatApp("WhatsApp");

        /*
            creating chat room named 'Study group' which will have multiple users
            and add the chat room in whatsApp chat application 
         */
        ChatRoom studyGroup = new ChatRoom("Study Group", 123456);
        whatsApp.createChatRoom(studyGroup);

        /* 
            creating users who can join multiple chat rooms and adding them into whatsapp
            chat application
        */
        User abhishek = new User("Abhishek", 234567);
        User saurabh = new User("Saurabh", 111222);
        User vikash = new User("Vikash", 324567);
        whatsApp.createUsers(abhishek);
        whatsApp.createUsers(saurabh);
        whatsApp.createUsers(vikash);

        /* 
            adding users to 'Study group' chat room
        */
        whatsApp.addUserToChatRoom(studyGroup.getChatRoomId(), abhishek.getUserId());
        whatsApp.addUserToChatRoom(studyGroup.getChatRoomId(), saurabh.getUserId());
        whatsApp.addUserToChatRoom(studyGroup.getChatRoomId(), vikash.getUserId());

        /*  abhishek is sending message in chat room which will be notified to all 
            the members except the sender itself
        */
        abhishek.sendMessage(new Message("Hello there!", abhishek, studyGroup));

        /*  saurabh is sending message in chat room which will be notified to all 
            the members except the sender itself
        */
        saurabh.sendMessage(new Message("Hey! How's going?", saurabh, studyGroup));
    }
}
