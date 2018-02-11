package pl.mesayah.lsystems;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LSystemTest {

    @Test
    public void testWordGeneration() {

        HashMap<Character, String> productions = new HashMap<>();
        productions.put('A', "AB");
        productions.put('B', "A");

        Set<Character> alphabet = new HashSet<>();
        alphabet.add('A');
        alphabet.add('B');
        LSystem system = new LSystem("A", productions);

        String generated = system.generate(4);
        Assert.assertEquals("ABAABABA", generated);
    }
}
