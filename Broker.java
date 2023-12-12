import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class Broker {
    private Map<String, Socket> subscribers = new HashMap<>();

    public void subscribe(String topic, Socket subscriber) {
        subscribers.put(topic, subscriber);
        System.out.println("Subscriber connected for topic: " + topic);
    }

    public void publish(String topic, String message) {
        Socket subscriber = subscribers.get(topic);
        if (subscriber != null) {
            try {
                PrintWriter out = new PrintWriter(subscriber.getOutputStream(), true);
                out.println("New message on topic '" + topic + "': " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
