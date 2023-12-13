import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Subscriber class
class Subscriber 
{
    private String name;

    public Subscriber(String name) 
    {
        this.name = name;
    }
    public String get_Name()
    {
        return name;
    }

    public void receiveMessage(Message message) 
    {
        System.out.println("[" + name + "]" + " Notification Message: " + message.getContent());
        System.out.println("----------------------------------------------------------------");
    }
}
