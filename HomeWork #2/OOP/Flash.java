package crochomework.OOP;

import java.util.ArrayList;

/**
 * Класс Flash является наследником класса MusicCarrier
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Flash extends MusicCarrier {

    public Flash(String name) {
        super(name);
    }

    public Flash(String name, ArrayList<Song> songs) {
        super(name, songs);
    }
}
