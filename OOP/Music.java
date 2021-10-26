package crochomework.OOP;

import java.util.Objects;

/**
 * Класс Music является прототипом музыкального файла
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Music {
    String name;
    String author;

    /**
     * Конструктор Music
     *
     * @param name   Название
     * @param author Исполнитель
     */
    public Music(String name, String author) {
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
        Music music = (Music) o;
        return Objects.equals(name, music.name) && Objects.equals(author, music.author);
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
