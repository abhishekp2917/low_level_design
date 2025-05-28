package BehaviouralPattern.ObserverPattern.example1.Solution;

import java.util.ArrayList;
import java.util.List;

/* 
    creating Channel class which will acts as an observable or subject and whenever an event 
    occurs it will notify all of its observers about the event and current status
*/
public class Channel {

    public String channelName;
    // lis to store all the subscriber of this channel
    private List <Subscriber> subscribers = new ArrayList<>(); 
    // list to store all the videos uploaded by this channel
    private List <Video> videos = new ArrayList<>(); 

    public Channel(String channelName) {
        this.channelName = channelName;
        System.out.println("Channel name: " + channelName + " created successfully!\n");
    }

    /* 
        method to upload new video and notify all the observers or subscribers about the 
        this update 
    */
    public void uploadVideo (Video newVideo) {
        // uploading video 
        videos.add(newVideo);
        System.out.println("Video titled: " + newVideo.getTitle() + " uploaded successfully!");
        // notifying all the subscriber
        notifySubscriber();
    }

    /* 
        method to notify all the subscriber about the update
    */
    public void notifySubscriber() {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(this); 
        }
        System.out.println();
    }

    /* 
        method to add subscriber to this channel
    */
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}