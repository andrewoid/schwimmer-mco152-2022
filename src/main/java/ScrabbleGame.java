import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The Model
 */
public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary;
    private LetterPool letterPool;

    public ScrabbleGame(
            ScrabbleDictionary dictionary,
            LetterPool letterPool
    ) {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        for (int i = 0; i < 7; i++)
            tiles.add(letterPool.getRandomLetter());
    }

    public List<Character> getTiles() {
        return tiles;
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list and add new *random* letters.
     *
     * @param word
     */
    public boolean playWord(String word) {
        if (!dictionary.isWord(word)) {
            return false;
        }

        char[] characters = word.toUpperCase(Locale.ROOT).toCharArray();
        List<Character> temp = new ArrayList<>(tiles);
        for (char character : characters) {
            if (!temp.remove((Character) character)) {
                return false;
            }
        }
        tiles = temp;

        playedWords.add(word);

        for (int i = tiles.size(); i < 7; i++) {
            tiles.add(letterPool.getRandomLetter());
        }

        return true;
    }

}
