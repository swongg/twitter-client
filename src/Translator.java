// Takes in an English message and outputs the message in morse code
// each character (0 -> 9, a -> z, !, ., ?, SPACE) is separated 1 space from each other
// each full word is separated 3 spaces from each other

import java.util.*;

public class Translator {
    private HashMap<Character, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<Character, String>();
        initializeDictionary();
    }

    // REQUIRED: only accepts A -> Z, 0 -> 9, commas, periods, questions marks, exclamation marks and
    // spaces
    public String encode(String message) {
        String messageInMorseCode = "";
        char[] characters = message.toLowerCase().toCharArray(); // array of characters
        for (int i = 0; i < message.length(); i++) {
            messageInMorseCode = messageInMorseCode + dictionary.get(characters[i]) + " ";
            // translate each character in array to morsecode character e -> . for example
        }

        return messageInMorseCode;
    }

    // REQUIRED: only accepts periods, underscores, single spaces and double spaces
    // Recall that each character is separated by a single space, each full word is separated by a double space
    public String decode(String message) {

        String messageInEnglish = ""; // this is eventually what we will be returning
        List<String> morseCodeWords = Arrays.asList(message.split("  ")); // 2 spaces, array of full words (in morse code format)
        List<String> morseCodeCharacters = new ArrayList<>(); // array of morse code characters ex: "._.." is a comma


        for (int i = 0; i < morseCodeWords.size(); i++) {
            String[] arr = (morseCodeWords.get(i).split(" ")); // 1 space, splits each morse code word into morse code character


            for (int j = 0; j < arr.length; j++) {
                morseCodeCharacters.add(arr[j]);
            }
        }

        // 'a' is key, "._" is the value (for dictionary hash map)
        for (String character : morseCodeCharacters) {
            for (Character theKey : dictionary.keySet()) {

                if (dictionary.get(theKey).equals("   ")) {
                    messageInEnglish = messageInEnglish + " ";

                } else if (dictionary.get(theKey).equals(character)) {
                    messageInEnglish = messageInEnglish + theKey; // adds the English Character
                }
            }

        }
        return messageInEnglish;
    }

    private void initializeDictionary() {
        dictionary.put('a', "._");
        dictionary.put('b', "_...");
        dictionary.put('c', "_._.");
        dictionary.put('d', "_..");
        dictionary.put('e', ".");
        dictionary.put('f', ".._.");
        dictionary.put('g', "__.");
        dictionary.put('h', "....");
        dictionary.put('i', "..");
        dictionary.put('j', ".___");
        dictionary.put('k', "_._");
        dictionary.put('l', "._..");
        dictionary.put('m', "__");
        dictionary.put('n', "_.");
        dictionary.put('o', "___");
        dictionary.put('p', ".__.");
        dictionary.put('q', "__._");
        dictionary.put('r', "._.");
        dictionary.put('s', "...");
        dictionary.put('t', "_");
        dictionary.put('u', ".._");
        dictionary.put('v', "..._");
        dictionary.put('w', ".__");
        dictionary.put('x', "_.._");
        dictionary.put('y', "_.__");
        dictionary.put('z', "__..");
        dictionary.put('0', "_____");
        dictionary.put('1', ".____");
        dictionary.put('2', "..___");
        dictionary.put('3', "...__");
        dictionary.put('4', "...._");
        dictionary.put('5', ".....");
        dictionary.put('6', "_....");
        dictionary.put('7', "__...");
        dictionary.put('8', "___..");
        dictionary.put('9', "____.");
        dictionary.put('?', "..__..");
        dictionary.put('.', "._._._");
        dictionary.put(',', "__..__");
        dictionary.put('!', "_..._");
        dictionary.put(' ', "   "); // empty space

    }
}
