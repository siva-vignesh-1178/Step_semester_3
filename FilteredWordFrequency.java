import java.util.HashMap;
import java.util.Map;

public class FilteredWordFrequency.java {

    static void printFilteredWordFrequency(String feedback) {

        String text = feedback.toLowerCase();

        text = text.replace(".", "");
        text = text.replace(",", "");

        String[] words = text.split("\\s+");

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        String[] uniqueWords =
            frequency.keySet().toArray(new String[0]);

        for (int i = 0; i < uniqueWords.length - 1; i++) {

            for (int j = i + 1; j < uniqueWords.length; j++) {

                if (frequency.get(uniqueWords[i]) <
                    frequency.get(uniqueWords[j])) {

                    String temp = uniqueWords[i];

                    uniqueWords[i] = uniqueWords[j];

                    uniqueWords[j] = temp;
                }
            }
        }

        for (String word : uniqueWords) {

            System.out.println(
                word + ": " + frequency.get(word)
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}