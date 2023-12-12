import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

// Broker class
class Broker {
    public static void main(String[] args) 
    {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");
        System.out.println(" -- Subscriber [1] -- ");
        // Subscribers choose topics to subscribe to
        System.out.println(" Choose What You Want To Subscribe To: ");
        
        System.out.println("[0]: None  ");
        System.out.println("[1]: News  ");
        System.out.println("[2]: Weather  ");

        publisher.addSubscriber("News", subscriber1);
        publisher.addSubscriber("Weather", subscriber1);

        System.out.println(" -- Subscriber [2] -- ");
        publisher.addSubscriber("Weather", subscriber2);

        // Publish messages to specific topics
        publisher.publishMessage("News", "Breaking news!");
        publisher.publishMessage("Weather", "Sunny day forecast!");

        // You can also remove subscribers from specific topics if needed
        // publisher.removeSubscriber("News", subscriber1);
    }
}