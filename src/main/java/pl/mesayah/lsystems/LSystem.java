package pl.mesayah.lsystems;

import java.util.*;

public class LSystem {

    private String axiom;
    private Map<Character, String> productions;


    public LSystem(String axiom, Map<Character, String> productions) {

            this.axiom = axiom;
            this.productions = productions;
    }


    public String getAxiom() {

        return axiom;
    }

    public void setAxiom(String axiom) {

        this.axiom = axiom;
    }

    public Map<Character, String> getProductions() {

        return productions;
    }

    public void setProductions(Map<Character, String> productions) {

        this.productions = productions;
    }

    public String generate(int length) {

        String generated = this.axiom;

        for(int i = 0; i < length; i++) {
            generated = rewrite(generated);
        }

        return generated;

    }

    private String rewrite(String word) {

        StringBuilder rewritten = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {

            Character character = word.charAt(i);
            String succestor = productions.get(character);
            if(succestor != null) {
                rewritten.append(succestor);
            } else {
                rewritten.append(character);
            }
        }

        return rewritten.toString();
    }
}
