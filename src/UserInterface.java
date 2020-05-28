import java.util.Scanner;

public class UserInterface {

    private TwitterStuff twit;
    private Translator translate;
    private Scanner reader;

    public UserInterface() {
        twit = new TwitterStuff();
        translate = new Translator();
        reader = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Please type your message or press 2 if you would like to quit.");
            String message = reader.nextLine();

            if (isStringInt(message) && Integer.parseInt(message) == 2) {
                break;
            }

            System.out.println("Press 0 if you want to tweet your message" +
                    "out in morse code. " +
                    "Press 1 if you want to tweet your message out in English.");

            String ans = reader.nextLine();

            if (isStringInt(ans)) {
                int answerAsInt = Integer.parseInt(ans);
                performAction(answerAsInt, message);
            } else {
                System.out.println("Your response is invalid. Please try again.");
            }

        }
    }

    public void performAction(int ans, String message) {
        if (ans == 0) {
            String inMorseCode = translate.encode(message);
            twit.newTweet(inMorseCode);

        } else if (ans == 1) {
            twit.newTweet(message);

        } else {
            System.out.println("Your response is invalid. Please try again.");
        }
    }

    public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
