package crochomework.OOP;

import java.util.ArrayList;

/**
 * Класс MusicRecord является наследником класса MusicCarrier
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class MusicRecord extends MusicCarrier {

    public MusicRecord(String name) {
        super(name);
    }

    public MusicRecord(String name, ArrayList<Song> songs) {
        super(name, songs);
    }
}
