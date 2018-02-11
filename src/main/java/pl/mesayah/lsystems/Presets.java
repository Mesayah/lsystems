package pl.mesayah.lsystems;

import java.util.*;

public class Presets {

    private static List<Preset> presets = new ArrayList<>();

    public static List<Preset> getPresets() {

        return presets;
    }

    public static void createPresets() {

        createFractalPresets();
        createPlantPresets();
    }

    private static void createPlantPresets() {

        Map<Character, String> productions = new HashMap<>();
        productions.put('F', "F[+F]F[-F]F");
        LSystem plant1System = new LSystem("F", productions);
        presets.add(new Preset("Plant 1", 25.7, plant1System, 5));

        productions = new HashMap<>();
        productions.put('F', "F[+F]F[-F][F]");
        LSystem plant2System = new LSystem("F", productions);
        presets.add(new Preset("Plant 2", 20, plant2System, 5));

        productions = new HashMap<>();
        productions.put('F', "FF-[-F+F+F]+[+F-F-F]");
        LSystem plant3System = new LSystem("F", productions);
        presets.add(new Preset("Plant 3", 22.5, plant3System, 4));

        productions = new HashMap<>();
        productions.put('F', "FF");
        productions.put('X', "F[+X]F[-X]+X");
        LSystem plant4System = new LSystem("X", productions);
        presets.add(new Preset("Plant 4", 20, plant4System, 7));

        productions = new HashMap<>();
        productions.put('F', "FF");
        productions.put('X', "F[+X][-X]FX");
        LSystem plant5System = new LSystem("X", productions);
        presets.add(new Preset("Plant 5", 25.7, plant5System, 7));

        productions = new HashMap<>();
        productions.put('F', "FF");
        productions.put('X', "F-[[X]+X]+F[+FX]-X");
        LSystem plant6System = new LSystem("X", productions);
        presets.add(new Preset("Plant 6", 22, plant6System, 5));


    }

    private static void createFractalPresets() {


        Map<Character, String> productions = new HashMap<>();
        productions.put('F', "F-F+F+FF-F-F+F");
        LSystem turtle1System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 1", 90, turtle1System, 2));

        productions = new HashMap<>();
        productions.put('F', "F+FF-FF-F-F+F+FF-F-F+F+FF+FF-F");
        LSystem turtle2System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 2", 90, turtle2System, 2));

        productions = new HashMap<>();
        productions.put('F', "F+F-F-F+F");
        LSystem turtle3System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 3", 90, turtle3System, 2));

        productions = new HashMap<>();
        productions.put('F', "F+f-FF+F+FF+Ff+FF-f+FF-F-FF-Ff-FFF");
        productions.put('f', "fffffff");
        LSystem turtle4System = new LSystem("F+F+F+F", productions);
        presets.add(new Preset("Turtle 4", 90, turtle4System, 2));

        productions = new HashMap<>();
        productions.put('F', "FF-F-F-F-F-F+F");
        LSystem turtle5System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 5", 90, turtle5System, 4));

        productions = new HashMap<>();
        productions.put('F', "FF-F-F-F-FF");
        LSystem turtle6System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 6", 90, turtle6System, 4));

        productions = new HashMap<>();
        productions.put('F', "FF-F+F-F-FF");
        LSystem turtle7System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 7", 90, turtle7System, 3));

        productions = new HashMap<>();
        productions.put('F', "FF-F--F-F");
        LSystem turtle8System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 8", 90, turtle8System, 4));

        productions = new HashMap<>();
        productions.put('F', "F-FF--F-F");
        LSystem turtle9System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 9", 90, turtle9System, 5));

        productions = new HashMap<>();
        productions.put('F', "F-F+F-F-F");
        LSystem turtle10System = new LSystem("F-F-F-F", productions);
        presets.add(new Preset("Turtle 10", 90, turtle10System, 4));

        productions = new HashMap<>();
        productions.put('F', "X+F+X");
        productions.put('X', "F-X-F");
        LSystem turtle11System = new LSystem( "X", productions);
        presets.add(new Preset("Turtle 11", 60, turtle11System, 6));
    }
}
