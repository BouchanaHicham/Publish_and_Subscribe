import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Message class to represent the data being published
class Message 
{
    private String content;

    public Message(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
}