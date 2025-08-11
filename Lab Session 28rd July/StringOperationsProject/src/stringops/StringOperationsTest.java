package stringops;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringOperationsTest {

    StringOperations ops = new StringOperations();

    @Test
    public void testHighestFrequencyChar() {
        String input = "programming";
        String expected = "Highest frequency character: 'g' occurred 2 times.";
        assertEquals(expected, ops.highestFrequencyChar(input));
    }

    @Test
    public void testReplaceFirstVowel() {
        String input = "elephant";
        String expected = "-lephant";
        assertEquals(expected, ops.replaceFirstVowel(input));
    }
}