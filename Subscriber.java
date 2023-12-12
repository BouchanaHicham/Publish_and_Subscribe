import java.io.*;
import java.net.*;


class Subscriber {
    public void subscribe(String topic, String brokerAddress, int brokerPort) {
        try {
            Socket socket = new Socket(brokerAddress, brokerPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Subscribe:" + topic);

            // Implement the logic to handle incoming messages from the broker
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
