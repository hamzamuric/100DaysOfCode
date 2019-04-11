package hundreddaysofcode.composite;

public class Main {

    public static void main(String[] args) {

        SongComponent industrialMusic = new SongGroup("Industrial",
                "is a style of experimental music that draws on transgressive and provocative themes");

        SongComponent heavyMetalMusic = new SongGroup("Heavy Metal",
                "is a genre of rock that developed in the late 1960s, largely in the UK and in the US");

        SongComponent dubstepMusic = new SongGroup("Industrial",
                "is a genre of electronic dance music that originated in South London, England");

        SongComponent everySong = new SongGroup("Son List", "Every Song Available");

        everySong.add(industrialMusic);
        industrialMusic.add(new Song("Head Like a Hole", "NIN", 1990));
        industrialMusic.add(new Song("Headhunter", "Front 242", 1988));

        industrialMusic.add(dubstepMusic);
        dubstepMusic.add(new Song("Centipede", "Knife Party", 2012));
        dubstepMusic.add(new Song("Tetris", "Doctor P", 2011));

        everySong.add(heavyMetalMusic);

        DiscJockey crazyLarry = new DiscJockey(everySong);
        crazyLarry.getSongList();

    }
}
