package crochomework.OOP;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс Player является прототипом плеера, выполняющий базовые его возможности:
 * Включение/Выключение
 * Вставить/Достать носитель информации(песен)
 * Включить следующую песню
 * Увеличить/Уменьшение громкости
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Player {
    String name;
    boolean state = false;
    int volume = 50;
    ArrayList<MusicCarrier> availableCarrier;
    MusicCarrier activeCarrier;
    int activeMusicId;

    /**
     * Конструктор Player
     *
     * @param name             Название
     * @param availableCarrier Список доступных к подключению носителей
     */
    public Player(String name, ArrayList<MusicCarrier> availableCarrier) {
        this.name = name;
        this.availableCarrier = availableCarrier;
    }

    /**
     * Вставить носитель в плеер
     *
     * @param carrier Носитель
     */
    public void insertCarrier(MusicCarrier carrier) {
        if (availableCarrier.contains(carrier)) {
            activeCarrier = carrier;
            activeMusicId = 0;
            System.out.printf("%s вставлен в %s%n", carrier.name, name);
        } else {
            System.out.printf("%s не поддерживает данный носитель%n", name);
        }
    }

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
        this.state = true;
        System.out.printf("%s включен%n", name);
        nextMusic();
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Включить следующую мелодию
     */
    public void nextMusic() {
        if (state) {
            if (activeCarrier != null) {
                Music activeMusic = activeCarrier.musics.get(activeMusicId);
                System.out.printf("В %s сейчас играет: %s - %s с %s  | Громкость=%d%n", this.name, activeMusic.name, activeMusic.author, this.activeCarrier.name, volume);
                if (activeMusicId + 1 != activeCarrier.musics.size()) {
                    activeMusicId++;
                } else {
                    System.out.printf("Плейлист из %s закончился и начнётся сначала%n", activeCarrier.name);
                    activeMusicId = 0;
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
        activeMusicId = 0;
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

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return state == player.state && volume == player.volume && activeMusicId == player.activeMusicId && Objects.equals(name, player.name) && Objects.equals(availableCarrier, player.availableCarrier) && Objects.equals(activeCarrier, player.activeCarrier);
    }

    public int hashCode() {
        return Objects.hash(name, state, volume, availableCarrier, activeCarrier, activeMusicId);
    }

    public String toString() {
        return "Плеер {" +
                "Название='" + name + '\'' +
                ", Состояние=" + state +
                ", Громкость=" + volume +
                ", Доступные носители=" + availableCarrier +
                ", Активный носитель=" + activeCarrier +
                '}';
    }
}
