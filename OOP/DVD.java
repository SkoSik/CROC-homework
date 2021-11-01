package crochomework.OOP;

import java.util.ArrayList;

/**
 * Класс DVD является наследником класса MusicCarrier
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class DVD extends MusicCarrier {

    public DVD(String name) {
        super(name);
    }

    public DVD(String name, ArrayList<Song> songs) {
        super(name, songs);
    }
}
