import java.io.*;
import java.net.*;


class Publisher {
    public void publish(String topic, String message, String brokerAddress, int brokerPort) {
        try {
            Socket socket = new Socket(brokerAddress, brokerPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Publish:" + topic + ":" + message);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

