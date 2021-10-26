package crochomework.OOP;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс MusicCarrier является прототипом носителя музыкальных файлов
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class MusicCarrier {
    String name;
    ArrayList<Music> musics;

    /**
     * Конструктор MusicCarrier
     *
     * @param name Название
     */
    public MusicCarrier(String name) {
        this.name = name;
    }

    /**
     * Конструктор MusicCarrier
     *
     * @param name   Название
     * @param musics Список песен
     */
    public MusicCarrier(String name, ArrayList<Music> musics) {
        this.name = name;
        this.musics = musics;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MusicCarrier that = (MusicCarrier) o;
        return Objects.equals(name, that.name) && Objects.equals(musics, that.musics);
    }

    public int hashCode() {
        return Objects.hash(name, musics);
    }

    public String toString() {
        return "Носитель {" +
                "Название='" + name + '\'' +
                ", Список музыки=" + musics +
                '}';
    }
}
