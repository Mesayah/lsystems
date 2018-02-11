package pl.mesayah.lsystems;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;

public class GrammarTest {

    @Test
    public void testWordConsistencyWithAlphabet() {

        String word = "qwertyQWERTY123456";
        Set<Character> alphabet = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {

            Character character = word.charAt(i);
            alphabet.add(character);
        }

        boolean consistent = GrammarUtils.isMadeWith(word, alphabet);
        Assert.assertTrue(consistent);

        word = "qwerty";
        consistent = GrammarUtils.isMadeWith(word, alphabet);
        Assert.assertTrue(consistent);

        word = "ASDFGH";
        consistent = GrammarUtils.isMadeWith(word, alphabet);
        Assert.assertFalse(consistent);
    }

    @Test
    public void testProductionConsistencyWithAlphabet() {

        Set<Character> alphabet = new HashSet<>();
        alphabet.add('A');
        alphabet.add('B');
        alphabet.add('C');

        Map<Character, String> productions = new HashMap<>();
        for (Character character : alphabet) {
            productions.put(character, "ABC");
        }

        boolean consistency = GrammarUtils.coversAlphabet(productions, alphabet);
        Assert.assertTrue(consistency);

        alphabet.add('D');
        consistency = GrammarUtils.coversAlphabet(productions, alphabet);
        Assert.assertTrue(consistency);

        productions.put('E', "ABCD");
        consistency = GrammarUtils.coversAlphabet(productions, alphabet);
        Assert.assertFalse(consistency);

        productions.remove('E');
        productions.put('D', "ABCDE");
        consistency = GrammarUtils.coversAlphabet(productions, alphabet);
        Assert.assertFalse(consistency);
    }
}
