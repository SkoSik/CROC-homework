package crochomework.OOP;

import java.util.Objects;

/**
 * Класс Song является прототипом музыкального файла
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Song {
    String name;
    String author;

    /**
     * Конструктор Song
     *
     * @param name   Название
     * @param author Исполнитель
     */
    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(name, song.name) && Objects.equals(author, song.author);
    }

    public int hashCode() {
        return Objects.hash(name, author);
    }

    public String toString() {
        return "Песня {" +
                "Название='" + name + '\'' +
                ", Автор='" + author + '\'' +
                '}';
    }
}
