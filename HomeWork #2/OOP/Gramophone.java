package crochomework.OOP;

/**
 * Класс Gramophone является наследником класса Player
 * Воспроизводит MusicRecord
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Gramophone extends Player {

    /**
     * Конструктор Gramophone
     *
     * @param name Название
     */
    public Gramophone(String name) {
        super(name);
    }

    /**
     * Вставить носитель в плеер
     *
     * @param carrier Носитель
     */
    public void insertCarrier(MusicCarrier carrier) {
        if (activeCarrier == null) {
            if (carrier instanceof MusicRecord) {
                activeCarrier = carrier;
                System.out.printf("%s успешно вставлен в %s", activeCarrier.name, name);
            } else {
                System.out.println("Нельзя вставить данный носитель информации");
            }
        } else {
            System.out.println("Нельзя вставить два носителя информации одновременно");
        }
    }
}
