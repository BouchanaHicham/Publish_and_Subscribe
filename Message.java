import java.io.Serializable;

// Message class to represent the data being published
class Message implements Serializable 
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
