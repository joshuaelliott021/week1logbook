import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private long playCount;

    public Song(String title, String artist, long playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Play Count: " + playCount;
    }
}

public class MusicApp {
    private ArrayList<Song> songs;
    private Scanner scanner;

    public MusicApp() {
        songs = new ArrayList<>();
        scanner = new Scanner(System.in);
        preloadSongs();
    }

    private void preloadSongs() {
        songs.add(new Song("Clint Eastwood", "Gorillaz", 1167536763L));
        songs.add(new Song("The Real Slim Shady", "Eminem", 2448424575L));
        songs.add(new Song("Song 2", "Blur", 1238991548L));
        songs.add(new Song("Band Practice Pt 2", "9th Wonder", 4629086L));
        songs.add(new Song("Big Poppa", "The Notorious B.I.G.", 1493074946L));
        songs.add(new Song("Black Hole Sun", "Chris Cornell", 1012857062L));
        songs.add(new Song("The Rubberband Man", "The Spinners", 208124401L));
        songs.add(new Song("Uplift", "Rakim", 6055145L));
        songs.add(new Song("505", "Arctic Monkeys", 2796744524L));
        songs.add(new Song("Flashing Lights", "Kanye West", 1732411641L));
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addSong();
                    break;
                case 2:
                    removeSong();
                    break;
                case 3:
                    printAllSongs();
                    break;
                case 4:
                    printSongsOverPlays();
                    break;
                case 5:
                    System.out.println("Exiting application, Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please choose 1-5.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n== Music Streaming Console App ==");
        System.out.println("1. Add a new song");
        System.out.println("2. Remove a song");
        System.out.println("3. Print all songs");
        System.out.println("4. Print songs with play count over a certain number");
        System.out.println("5. Exit");
    }

    private void addSong() {
        System.out.println("\n--- Add New Song ---");
        System.out.print("Enter song title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine().trim();

        long playCount = getLongInput("Enter play count: ");

        Song newSong = new Song(title, artist, playCount);
        songs.add(newSong);
        System.out.println("Song added successfully!");
    }

    private void removeSong() {
        System.out.println("\n--- Remove Song ---");
        if (songs.isEmpty()) {
            System.out.println("No songs to remove.");
            return;
        }

        printAllSongs();
        int index = getIntInput("Enter the number of the song to remove: ") - 1;

        if (index < 0 || index >= songs.size()) {
            System.out.println("Invalid song number.");
        } else {
            Song removed = songs.remove(index);
            System.out.println("Removed: " + removed.getTitle() + " by " + removed.getArtist());
        }
    }

    private void printAllSongs() {
        System.out.println("\n--- All Songs ---");
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
            return;
        }

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    private void printSongsOverPlays() {
        System.out.println("\n--- Songs with Play Count Over ---");
        long threshold = getLongInput("Enter play count threshold: ");

        boolean found = false;
        for (Song song : songs) {
            if (song.getPlayCount() > threshold) {
                System.out.println(song);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No songs found with play count over " + threshold);
        }
    }

    private int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private long getLongInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Long.parseLong(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        MusicApp app = new MusicApp();
        app.start();
    }
}