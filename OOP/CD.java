package crochomework.OOP;

import java.util.ArrayList;

/**
 * Класс CD является наследником класса MusicCarrier
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class CD extends MusicCarrier {

    public CD(String name) {
        super(name);
    }

    public CD(String name, ArrayList<Song> songs) {
        super(name, songs);
    }
}
