import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Message class to represent the data being published
class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Publisher class
class Publisher {
    private Map<String, List<Subscriber>> topicSubscribers = new HashMap<>();

    public void addSubscriber(String topic, Subscriber subscriber) {
        topicSubscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void removeSubscriber(String topic, Subscriber subscriber) {
        topicSubscribers.getOrDefault(topic, new ArrayList<>()).remove(subscriber);
    }

    public void publishMessage(String topic, String messageContent) {
        Message message = new Message(messageContent);

        for (Subscriber subscriber : topicSubscribers.getOrDefault(topic, new ArrayList<>())) {
            subscriber.receiveMessage(message);
        }
    }
}

// Subscriber class
class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void receiveMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }
}

// Broker class
class Broker {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        // Subscribers choose topics to subscribe to
        publisher.addSubscriber("News", subscriber1);
        publisher.addSubscriber("Weather", subscriber2);

        // Publish messages to specific topics
        publisher.publishMessage("News", "Breaking news!");
        publisher.publishMessage("Weather", "Sunny day forecast!");

        // You can also remove subscribers from specific topics if needed
        // publisher.removeSubscriber("News", subscriber1);
    }
}
