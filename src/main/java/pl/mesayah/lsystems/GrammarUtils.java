package pl.mesayah.lsystems;

import java.util.Map;
import java.util.Set;

public class GrammarUtils {

    public static boolean isMadeWith(String word, Set<Character> alphabet) {

        for (int i = 0; i < word.length(); i++) {

            Character character = word.charAt(i);
            if (!alphabet.contains(character)) {
                return false;
            }
        }

        return true;
    }

    public static boolean coversAlphabet(Map<Character, String> productions, Set<Character> alphabet) {

        for (Character character : productions.keySet()) {
            if (!alphabet.contains(character)) {
                return false;
            }
        }

        for (String string : productions.values()) {

            if (!isMadeWith(string, alphabet)) {
                return false;
            }
        }

        return true;
    }
}
