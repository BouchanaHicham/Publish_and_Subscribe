import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Publisher class
class Publisher 
{
    private Map<String, List<Subscriber>> topicSubscribers = new HashMap<>();

    public void addSubscriber(String topic, Subscriber subscriber) 
    {
        topicSubscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void removeSubscriber(String topic, Subscriber subscriber) 
    {
        topicSubscribers.getOrDefault(topic, new ArrayList<>()).remove(subscriber);
    }

    public void publishMessage(String topic, String messageContent) 
    {
        Message message = new Message(messageContent);

        for (Subscriber subscriber : topicSubscribers.getOrDefault(topic, new ArrayList<>())) 
        {
            subscriber.receiveMessage(message);
        }
    }
}
