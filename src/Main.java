import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlaylistManager playlistManager = new PlaylistManager();
        // Load songs from the directory into the playlist
        File musicDir = new File("C:\\Users\\racha\\IdeaProjects\\MUSIC PLAYLIST MANAGEMENT\\music");
        if (musicDir.isDirectory()) {
            File[] songFiles = musicDir.listFiles((dir, name) -> name.endsWith(".mp3"));
            if (songFiles != null) {
                for (File songFile : songFiles) {
                    playlistManager.adddata(songFile.getName());
                }
            }
        }
        playlistManager.printdata();
        // User interaction for playlist management
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlaylist Manager");
            System.out.println("1. Add Song");
            System.out.println("2. Delete Song");
            System.out.println("3. Search Song");
            System.out.println("4. Play Song");
            System.out.println("5. View Play History");
            System.out.println("6. View Playlist");
            System.out.println("7.play next");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add: ");
                    String songToAdd = scanner.nextLine();
                    playlistManager.adddata(songToAdd);
                    System.out.println(songToAdd + " added to playlist.");
                    break;
                case 2:
                    System.out.print("Enter song name to delete: ");
                    String songToDelete = scanner.nextLine();
                    playlistManager.delete(songToDelete);
                    break;
                case 3:
                    System.out.print("Enter song name to search: ");
                    String songToSearch = scanner.nextLine();
                    int index = playlistManager.search(songToSearch);
                    if (index != -1) {
                        System.out.println(songToSearch + " found in playlist.");
                    } else {
                        System.out.println(songToSearch + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter song name to play: ");
                    String songToPlay = scanner.nextLine();
                    playlistManager.play(songToPlay);
                    break;
                case 5:
                    playlistManager.recentlyplayed();
                    break;
                case 6:
                    playlistManager.printdata();
                    break;
                case 7:
                    System.out.print("Enter song name to play next: ");
                    String songToPlayNext = scanner.nextLine();
                    playlistManager.playnext(songToPlayNext);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
