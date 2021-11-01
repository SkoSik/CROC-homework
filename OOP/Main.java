package crochomework.OOP;

import java.util.ArrayList;

/**
 * HomeWork #2
 *
 * @author Slobodyan Ilya (SkoSik)
 */

public class Main {

    public static void main(String[] args) {
        Gramophone gramophone = new Gramophone("Граммофон");
        PCPlayer pcPlayer = new PCPlayer("ПК-плеер");
        MusicCenter musicCenter = new MusicCenter("Музыкальный центр");

        CD cd = new CD("CD диск");
        DVD dvd = new DVD("DVD диск");
        Flash flash = new Flash("Флеш-накопитель");
        MusicRecord musicRecord = new MusicRecord("Пластинка");

        ArrayList<Song> oldMusic = new ArrayList<>();
        oldMusic.add(new Song("Пять причин", "Игорь Николаев"));
        oldMusic.add(new Song("Широка река", "Надежда Кадышева"));
        oldMusic.add(new Song("Лабрадор / Гибралтар", "Террариум"));

        ArrayList<Song> middleMusic = new ArrayList<>();
        middleMusic.add(new Song("Stay With Me", "Sam Smith"));
        middleMusic.add(new Song("You're My Heart, You're My Soul", "Modern Talking"));
        middleMusic.add(new Song("Careless Whisper", "George Michael"));
        middleMusic.add(new Song("Can´t Stop The Feeling", "Justin Stopfeel"));
        middleMusic.add(new Song("You Can Win If You Want", "Modern Talking"));

        ArrayList<Song> newMusic = new ArrayList<>();
        newMusic.add(new Song("Cake By The Ocean", "DNCE"));
        newMusic.add(new Song("Angels", "Morandi"));
        newMusic.add(new Song("Sofia", "Alvaro Soler"));
        newMusic.add(new Song("Da da da", "Tobi King"));

        ArrayList<Song> musicForMusicRecord = new ArrayList<>();
        musicForMusicRecord.addAll(oldMusic);
        musicRecord.setSongs(musicForMusicRecord);

        ArrayList<Song> musicForFlash = new ArrayList<>();
        musicForFlash.addAll(newMusic);
        flash.setSongs(musicForFlash);

        ArrayList<Song> musicForCD = new ArrayList<>();
        musicForCD.addAll(middleMusic);
        musicForCD.addAll(newMusic);
        cd.setSongs(musicForCD);

        ArrayList<Song> musicForDVD = new ArrayList<>();
        musicForDVD.addAll(oldMusic);
        musicForDVD.addAll(middleMusic);
        dvd.setSongs(musicForDVD);

        gramophone.insertCarrier(flash);
        pcPlayer.insertCarrier(cd);
        pcPlayer.play();
        pcPlayer.nextMusic();
        pcPlayer.stop();
        pcPlayer.play();
        pcPlayer.upVolume();
        pcPlayer.upVolume();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.nextMusic();
        pcPlayer.takeCarrier();
        pcPlayer.nextMusic();
    }
}