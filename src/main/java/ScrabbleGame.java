import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame {

    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary = new ScrabbleDictionary();

    public ScrabbleGame() {
        // give the player 7 random tiles.
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list and add new *random* letters.
     *
     * @param word
     */
    public boolean playWord(String word) {
        return false;
    }

}
