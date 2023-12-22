import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Publisher class
class Publisher 
{
    private Map<String, List<Subscriber>> topicSubscribers = new HashMap<>();
    private ServerSocket serverSocket;

    public Publisher(int port) throws IOException 
    {
        this.serverSocket = new ServerSocket(port);  // Creates A Server
        System.out.println("Publisher is running on port " + port);
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();  // Acepts Requests of sub Connection
                    handleSubscriber(socket); // Handles that sub
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    // Activates Listening to the buffer in the port from sub
    private void handleSubscriber(Socket socket) throws IOException 
    {
        Subscriber subscriber = new Subscriber(socket);
        new Thread(() -> 
        {
            try 
            {
                subscriber.listenForMessages();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    // adds subs and their topics to our Array list
    public void addSubscriber(String topic, Subscriber subscriber) {
        //This method associates a Subscriber with a specific topic in the topicSubscribers map.
        topicSubscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    } //If the topic is already present, it retrieves the existing list of subscribers and adds the new Subscriber to it.

    // Sends the Message to the port
    public void publishMessage(String topic, String messageContent) 
    {
        Message message = new Message(messageContent);
        // retrieves the list of subscribers associated with the given topic 
        for (Subscriber subscriber : topicSubscribers.getOrDefault(topic, new ArrayList<>())) 
        {
            //it iterates through the list and sends the message to each subscriber using 
            subscriber.sendMessage(message);
        }
    }
}
