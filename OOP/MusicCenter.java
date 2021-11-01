package crochomework.OOP;

/**
 * Класс MusicCenter является наследником класса Player
 * Воспроизводит CD, DVD и Flash
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class MusicCenter extends Player {
    /**
     * Конструктор MusicCenter
     *
     * @param name Название
     */
    public MusicCenter(String name) {
        super(name);
    }

    /**
     * Вставить носитель в плеер
     *
     * @param carrier Носитель
     */
    public void insertCarrier(MusicCarrier carrier) {
        if (activeCarrier == null) {
            if (carrier instanceof CD || carrier instanceof DVD || carrier instanceof Flash) {
                activeCarrier = carrier;
            } else {
                System.out.println("Нельзя вставить данный носитель информации");
            }
        } else {
            System.out.println("Нельзя вставить два носителя информации одновременно");
        }
    }
}
