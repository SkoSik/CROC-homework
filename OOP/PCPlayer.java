package crochomework.OOP;

/**
 * Класс PCPlayer является наследником класса Player
 * Воспроизводит CD и Flash
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class PCPlayer extends Player {
    /**
     * Конструктор PCPlayer
     *
     * @param name Название
     */
    public PCPlayer(String name) {
        super(name);
    }

    /**
     * Вставить носитель в плеер
     *
     * @param carrier Носитель
     */
    public void insertCarrier(MusicCarrier carrier) {
        if (activeCarrier == null) {
            if (carrier instanceof CD || carrier instanceof Flash) {
                activeCarrier = carrier;
            } else {
                System.out.println("Нельзя вставить данный носитель информации");
            }
        } else {
            System.out.println("Нельзя вставить два носителя информации одновременно");
        }
    }
}