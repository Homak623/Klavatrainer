package sample.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TextCreatorTest {

    private static final String SYMBOLS = "dfjksal;vbnmtgyheruiqwopcx,.z/[]";

    private final TextCreator textCreator = new TextCreator();

    @Test
    void shiftTextRemovesFirstSymbol() {
        assertEquals("bcd", textCreator.shiftText("abcd"));
    }

    @Test
    void shiftTextOfSingleSymbolGivesEmptyString() {
        assertEquals("", textCreator.shiftText("a"));
    }

    @Test
    void shiftTextOfEmptyStringThrows() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> textCreator.shiftText(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void newTextHasElevenSymbols(String level) {
        assertEquals(11, textCreator.newText(level).length());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void newTextUsesOnlySymbolsOfLevel(int level) {
        String allowed = SYMBOLS.substring(0, level * 4);
        for (int attempt = 0; attempt < 50; attempt++) {
            String text = textCreator.newText(Integer.toString(level));
            for (char symbol : text.toCharArray()) {
                assertTrue(allowed.indexOf(symbol) != -1,
                        "symbol '" + symbol + "' is not allowed on level " + level);
            }
        }
    }

    @Test
    void newTextOnFirstLevelUsesHomeRowOnly() {
        String text = textCreator.newText("1");
        assertTrue(text.matches("[dfjk]+"), text);
    }

    @Test
    void newTextWithNonNumericLevelThrows() {
        assertThrows(NumberFormatException.class, () -> textCreator.newText("level1"));
    }

    @Test
    void newTextWithZeroLevelThrows() {
        assertThrows(IllegalArgumentException.class, () -> textCreator.newText("0"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void generatedTextIsGoodForItsLevel(int level) {
        String levelString = Integer.toString(level);
        assertTrue(textCreator.gootTextForLevel(levelString, textCreator.newText(levelString)));
    }

    @Test
    void textWithSymbolOfNextLevelIsNotGood() {
        // на уровне 1 доступны "dfjk", символ с индексом 5 ("a") относится к уровню 2
        assertFalse(textCreator.gootTextForLevel("1", "dfjka"));
    }

    @Test
    void textWithSymbolsOfCurrentLevelIsGood() {
        assertTrue(textCreator.gootTextForLevel("2", "dfjksal;"));
    }
}
