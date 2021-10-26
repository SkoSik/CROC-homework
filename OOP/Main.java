package crochomework.OOP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * HomeWork #2
 *
 * @author Slobodyan Ilya (SkoSik)
 */

public class Main {

    public static void main(String[] args) {
        MusicCarrier musicRecord = new MusicCarrier("Пластинка");
        MusicCarrier flash = new MusicCarrier("Флеш-накопитель");
        MusicCarrier CD = new MusicCarrier("CD диск");
        MusicCarrier DVD = new MusicCarrier("DVD диск");

        Player gramophone = new Player("Граммофон", new ArrayList<>(Arrays.asList(new MusicCarrier[]{musicRecord})));
        Player PCSpeaker = new Player("ПК-плеер", new ArrayList<>(Arrays.asList(new MusicCarrier[]{flash, CD})));
        Player MusicCenter = new Player("Граммофон", new ArrayList<>(Arrays.asList(new MusicCarrier[]{flash, CD, DVD})));

        ArrayList<Music> oldMusic = new ArrayList<>();
        oldMusic.add(new Music("Пять причин", "Игорь Николаев"));
        oldMusic.add(new Music("Широка река", "Надежда Кадышева"));
        oldMusic.add(new Music("Лабрадор / Гибралтар", "Террариум"));

        ArrayList<Music> middleMusic = new ArrayList<>();
        middleMusic.add(new Music("Stay With Me", "Sam Smith"));
        middleMusic.add(new Music("You're My Heart, You're My Soul", "Modern Talking"));
        middleMusic.add(new Music("Careless Whisper", "George Michael"));
        middleMusic.add(new Music("Can´t Stop The Feeling", "Justin Stopfeel"));
        middleMusic.add(new Music("You Can Win If You Want", "Modern Talking"));

        ArrayList<Music> newMusic = new ArrayList<>();
        newMusic.add(new Music("Cake By The Ocean", "DNCE"));
        newMusic.add(new Music("Angels", "Morandi"));
        newMusic.add(new Music("Sofia", "Alvaro Soler"));
        newMusic.add(new Music("Da da da", "Tobi King"));

        ArrayList<Music> musicForMusicRecord = new ArrayList<>();
        musicForMusicRecord.addAll(oldMusic);
        musicRecord.setMusics(musicForMusicRecord);

        ArrayList<Music> musicForFlash = new ArrayList<>();
        musicForFlash.addAll(newMusic);
        flash.setMusics(musicForFlash);

        ArrayList<Music> musicForCD = new ArrayList<>();
        musicForCD.addAll(middleMusic);
        musicForCD.addAll(newMusic);
        CD.setMusics(musicForCD);

        ArrayList<Music> musicForDVD = new ArrayList<>();
        musicForDVD.addAll(oldMusic);
        musicForDVD.addAll(middleMusic);
        DVD.setMusics(musicForDVD);

        gramophone.insertCarrier(flash);
        PCSpeaker.insertCarrier(CD);
        PCSpeaker.play();
        PCSpeaker.nextMusic();
        PCSpeaker.stop();
        PCSpeaker.play();
        PCSpeaker.upVolume();
        PCSpeaker.upVolume();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.nextMusic();
        PCSpeaker.takeCarrier();
        PCSpeaker.nextMusic();
    }
}