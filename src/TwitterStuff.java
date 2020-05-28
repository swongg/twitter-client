import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class TwitterStuff {
    private Twitter myTwitter = TwitterFactory.getSingleton();

    public void newTweet(String message) {
        try {
            Status status = myTwitter.updateStatus(message);
            System.out.println("Your tweet was successful");
        } catch (TwitterException e) {
            e.printStackTrace();
        }

    }
}

