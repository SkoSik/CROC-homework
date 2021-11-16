package crochomework.OOP;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс MusicCarrier является абстрактным прототипом носителя музыкальных файлов
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public abstract class MusicCarrier {
    String name;
    ArrayList<Song> songs;
    int activeSongId = 0;

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
     * @param name  Название
     * @param songs Список песен
     */
    public MusicCarrier(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MusicCarrier that = (MusicCarrier) o;
        return Objects.equals(name, that.name) && Objects.equals(songs, that.songs);
    }

    public int hashCode() {
        return Objects.hash(name, songs);
    }

    public String toString() {
        return "Носитель {" +
                "Название='" + name + '\'' +
                ", Список музыки=" + songs +
                '}';
    }
}
