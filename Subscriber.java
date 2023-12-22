import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Subscriber class
class Subscriber {
    private String name ="";
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Subscriber(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }
    // Listens for the Message that gets sent from the Publisher (Notification) | Reads It From The BUffer 
    public void listenForMessages() throws IOException 
    {
        while (true) 
        {
            String message = reader.readLine();
            if (message == null) 
            {
                break;
            }
            receiveMessage(new Message(message));
        }
    }
    // Prints the Recieved Msg
    public void receiveMessage(Message message) 
    {
        System.out.println(""+this.hashCode()+" Notification Message: " + message.getContent());
        System.out.println("----------------------------------------------------------------");
    }

    // Reads the message from the Buffer
    public void sendMessage(Message message) 
    {
        writer.println(message.getContent());
    }
}
