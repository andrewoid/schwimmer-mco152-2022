import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleDictionaryTest {

    @Test
    void isWord_true() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertTrue(dictionary.isWord("happy"));
    }

    @Test
    void isWord_false() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertFalse(dictionary.isWord("hapy"));
    }

    @Test
    void isWord_fragment() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertFalse(dictionary.isWord("happ"));
    }

    @Test
    void isWord_ZOOGEOGRAPHICAL() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertTrue(dictionary.isWord("ZOOGEOGRAPHICAL"));
    }

    @Test
    void getDefinition() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when
        String definition = dictionary.getDefinition("spacey");

        // then
        assertEquals("weird in behavior [adj SPACIER, SPACIEST]", definition);
    }
}