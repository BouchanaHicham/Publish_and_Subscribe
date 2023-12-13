import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


// Broker class
class Broker {
    public static void main(String[] args) 
    {
        Publisher publisher = new Publisher();
        Scanner scanner = new Scanner(System.in);
        

    
        Subscriber subscriber1 = new Subscriber("Hicham");
        Subscriber subscriber2 = new Subscriber("Khaled");
        System.out.println(" -- "+ subscriber1.get_Name() +" -- ");
        // Subscribers choose topics to subscribe to
        System.out.println(" Choose What You Want To Subscribe To: ");
        
        
        System.out.println("[1]: Temperature  ");
        System.out.println("[2]: Humidity  ");
        System.out.println("[3]: Temperature + Humidity  ");

        int userChoice = scanner.nextInt();
        Sub_To_Topic(userChoice,publisher,subscriber1);
        
        System.out.println(" -- "+ subscriber2.get_Name() +" -- ");
        // Subscribers choose topics to subscribe to
        System.out.println(" Choose What You Want To Subscribe To: ");
        
        
        System.out.println("[1]: Temperature  ");
        System.out.println("[2]: Humidity  ");
        System.out.println("[3]: Temperature + Humidity  ");

        userChoice = scanner.nextInt();
        Sub_To_Topic(userChoice,publisher,subscriber2);
        
        do
        {
            System.out.println("####################################");
            System.out.println(" Choose What You Want To Publish ");
            System.out.println("####################################");
            System.out.println("[1]: Publish Temperature ");
            System.out.println("[2]: Publish Humidity ");
            System.out.println("[3]: Publish Temperature + Humidity");
            System.out.println("####################################");
                userChoice = scanner.nextInt();
                // Publish messages to specific topics
                Publish_To_Subs(userChoice,publisher);
        }while(userChoice!=0);    

        // You can also remove subscribers from specific topics if needed
        // publisher.removeSubscriber("Temperature", subscriber1);
    }

    public static void Sub_To_Topic(int userChoice,Publisher publisher ,Subscriber subscriber)
    {
        switch (userChoice) 
        {
            
            case 1:
                publisher.addSubscriber("Temperature", subscriber);
                break;
            case 2:
                publisher.addSubscriber("Humidity", subscriber);
                break;
            case 3:
                publisher.addSubscriber("Temperature", subscriber);
                publisher.addSubscriber("Humidity", subscriber);
                break;

        }
    }

    public static void Publish_To_Subs(int userChoice,Publisher publisher)
    {
        Random rand = new Random();
        
        switch (userChoice) 
        {
            case 1:
                publisher.publishMessage("Temperature", "Temp is: "+ rand.nextInt(101) + "°");
                break;
            case 2:
                publisher.publishMessage("Humidity", "Humidity is at: "+ rand.nextInt(101) + "%");
                break;
            case 3:
                publisher.publishMessage("Temperature", "Temp Is: "+ rand.nextInt(101) + "°");
                publisher.publishMessage("Humidity", "Humidity is at: "+ rand.nextInt(101) + "%");
        }
    }
}