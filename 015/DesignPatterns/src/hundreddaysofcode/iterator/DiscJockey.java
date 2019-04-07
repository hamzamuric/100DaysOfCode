package hundreddaysofcode.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class DiscJockey {

    /*
    SongsOfThe70s songsOfThe70s;
    SongsOfThe80s songsOfThe80s;
    SongsOfThe90s songsOfThe90s;
    */

    SongIterator iter70sSongs;
    SongIterator iter80sSongs;
    SongIterator iter90sSongs;

    public DiscJockey(SongIterator iter70sSongs, SongIterator iter80sSongs, SongIterator iter90sSongs) {
        this.iter70sSongs = iter70sSongs;
        this.iter80sSongs = iter80sSongs;
        this.iter90sSongs = iter90sSongs;
    }

    /*
    public void showTheSongs() {
        ArrayList<SongInfo> arrayList = songsOfThe70s.getBestSongs();
        System.out.println("Songs of the 70s");
        for (int i = 0; i < arrayList.size(); i++) {
            SongInfo songInfo = arrayList.get(i);
            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased());
        }

        SongInfo[] songs80s = songsOfThe80s.getBestSongs();
        System.out.println("Songs of the 80s");
        for (int i = 0; i < songs80s.length; i++) {
            SongInfo songInfo = songs80s[i];
            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased());
        }

        Hashtable<Integer, SongInfo> songs90s = songsOfThe90s.getBestSongs();
        System.out.println("Songs of the 90s");
        for (Enumeration<Integer> e = songs90s.keys(); e.hasMoreElements();) {
            SongInfo songInfo = songs90s.get(e.nextElement());
            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased());
        }
    }
    */

    public void showTheSongs() {
        Iterator songs70s = iter70sSongs.createIterator();
        Iterator songs80s = iter80sSongs.createIterator();
        Iterator songs90s = iter90sSongs.createIterator();

        System.out.println("Songs of the 70s");
        printTheSongs(songs70s);
        System.out.println("Songs of the 80s");
        printTheSongs(songs80s);
        System.out.println("Songs of the 90s");
        printTheSongs(songs90s);
    }

    public void printTheSongs(Iterator iterator) {
        while (iterator.hasNext()) {
            SongInfo bestSong = (SongInfo) iterator.next();

            System.out.println(bestSong.getSongName());
            System.out.println(bestSong.getBandName());
            System.out.println(bestSong.getYearReleased());
        }
    }
}
