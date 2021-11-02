package crochomework.OOP;

import java.util.Objects;

/**
 * Класс Player является абстрактным прототипом плеера, выполняющий базовые его возможности:
 * Включение/Выключение
 * Вставить/Достать носитель информации(песен)
 * Включить следующую песню
 * Увеличить/Уменьшение громкости
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public abstract class Player {
    String name;
    boolean state = false;
    int volume = 50;
    MusicCarrier activeCarrier;

    /**
     * Конструктор Player
     *
     * @param name Название
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Вставить носитель в плеер
     *
     * @param carrier Носитель
     */
    public abstract void insertCarrier(MusicCarrier carrier);

    /**
     * Достать носитель из плеера
     */
    public void takeCarrier() {
        System.out.printf("%s извлечён%n", activeCarrier.name);
        activeCarrier = null;
    }

    /**
     * Запустить плеер
     */
    public void play() {
        state = true;
        System.out.printf("%s включен%n", name);
        nextMusic();
    }

    /**
     * Включить следующую мелодию
     */
    public void nextMusic() {
        if (state) {
            if (activeCarrier != null) {
                Song activeMusic = activeCarrier.songs.get(activeCarrier.activeSongId);
                System.out.printf("В %s сейчас играет: %s - %s с %s  | Громкость=%d%n", this.name, activeMusic.name, activeMusic.author, this.activeCarrier.name, volume);
                if (activeCarrier.activeSongId + 1 != activeCarrier.songs.size()) {
                    activeCarrier.activeSongId++;
                } else {
                    System.out.printf("Плейлист из %s закончился и начнётся сначала%n", activeCarrier.name);
                    activeCarrier.activeSongId = 0;
                }
            } else {
                System.out.println("Носитель с музыкой не найден");
            }
        } else {
            System.out.printf("%s выключен%n", name);
        }
    }

    /**
     * Выключить плеер
     */
    public void stop() {
        state = false;
        System.out.printf("%s выключен%n", name);
    }

    /**
     * Увеличить громкость на 10 единиц
     */
    public void upVolume() {
        if (volume < 100) {
            volume += 10;
        }
        System.out.printf("Громкость установлена: %d%n", volume);
    }

    /**
     * Уменьшить громкость на 10 единиц
     */
    public void downVolume() {
        if (volume > 0) {
            volume -= 10;
        }
        System.out.printf("Громкость установлена: %d%n", volume);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public String toString() {
        return "Плеер {" +
                "Название='" + name + '\'' +
                ", Состояние=" + state +
                ", Громкость=" + volume +
                ", Вставленный носитель=" + activeCarrier +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return state == player.state && volume == player.volume && Objects.equals(name, player.name) && Objects.equals(activeCarrier, player.activeCarrier);
    }

    public int hashCode() {
        return Objects.hash(name, state, volume, activeCarrier);
    }
}
