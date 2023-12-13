import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        
        
        System.out.println("[1]: News  ");
        System.out.println("[2]: Weather  ");
        System.out.println("[3]: News + Weather  ");

        int userChoice = scanner.nextInt();
        Sub_To_Topic(userChoice,publisher,subscriber1);
        
        System.out.println(" -- "+ subscriber2.get_Name() +" -- ");
        // Subscribers choose topics to subscribe to
        System.out.println(" Choose What You Want To Subscribe To: ");
        
        
        System.out.println("[1]: News  ");
        System.out.println("[2]: Weather  ");
        System.out.println("[3]: News + Weather  ");

        userChoice = scanner.nextInt();
        Sub_To_Topic(userChoice,publisher,subscriber2);
        
        do
        {
            System.out.println(" Choose What You Want To Publish ");

            System.out.println("[1]: Publish News ");
            System.out.println("[2]: Publish Weather ");
            System.out.println("[3]: Publish News + Weather ");
            
                userChoice = scanner.nextInt();
                // Publish messages to specific topics
                Publish_To_Subs(userChoice,publisher);
        }while(userChoice!=0);    

        // You can also remove subscribers from specific topics if needed
        // publisher.removeSubscriber("News", subscriber1);
    }

    public static void Sub_To_Topic(int userChoice,Publisher publisher ,Subscriber subscriber)
    {
        switch (userChoice) 
        {
            
            case 1:
                publisher.addSubscriber("News", subscriber);
                break;
            case 2:
                publisher.addSubscriber("Weather", subscriber);
                break;
            case 3:
                publisher.addSubscriber("News", subscriber);
                publisher.addSubscriber("Weather", subscriber);
                break;

        }
    }

    public static void Publish_To_Subs(int userChoice,Publisher publisher)
    {
        switch (userChoice) 
        {
            case 1:
                publisher.publishMessage("News", "Breaking news!");
                break;
            case 2:
                publisher.publishMessage("Weather", "Sunny day forecast!");
                break;
            case 3:
                publisher.publishMessage("News", "Breaking news!");
                publisher.publishMessage("Weather", "Sunny day forecast!");
        }
    }
}