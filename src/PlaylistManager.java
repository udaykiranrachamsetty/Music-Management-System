import java.util.Objects;
import java.util.*;
public class PlaylistManager {
    node head ;
    node tail ;
    Scanner input = new Scanner(System.in);
    CustomStack playhistory;
    public PlaylistManager(){
        this.head = null;
        this.tail = null;
        this.playhistory = new CustomStack();
    }

    public void adddata(String data){
        node newnode = new node(data);
        if(this.head == null && this.tail == null){
            this.head = newnode;
            this.tail = newnode;
        }
        this.tail.next = newnode;
        newnode.prev = this.tail;
        this.tail = newnode;
    }

    public void delete(String data){
        int index = search(data);
        node temp = this.head;
        if(index != -1){
            for(int i = 0 ; i < index-1;i++){
                temp = temp.next;
            }
            System.out.println(temp.data);
            System.out.println(temp.next.data);
            if(temp.next.next == null){
                temp.next = null;
                this.tail = temp;
            }
            else{
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }
        }
        else{
            System.out.println("not present");
        }
    }
    public int search(String data){
        int i = 0;
        node temp = this.head;
        while(temp.next != null){
            if(Objects.equals(temp.data, data)){
                return i ;
            }
            i++;
            temp = temp.next;
        }
        if(Objects.equals(temp.data, data)){
            return i ;
        }
        return -1;
    }

    public int count(){
        int i = 0 ;
        node temp = this.head;
        while(temp.next != null){
            i++;
            temp = temp.next;
        }
        return i+1;
    }

    public void play(String song) {
        int searchResult = search(song);
        if(searchResult != -1){
            System.out.println("Now playing: " + song);
            this.playhistory.push(song);
        }
        else{
            System.out.println("Song not found.");
        }
    }

    public void playnext(String songToPlayNext) {
        if(this.playhistory.getSize() == 0){
            System.out.println("No songs have been played yet. Playing the requested song...");
            play(songToPlayNext);
        }
        else{
            int currentIndex = search(this.playhistory.peek());
            if(search(songToPlayNext) != -1){
                delete(songToPlayNext);
                addmiddle(currentIndex, songToPlayNext);
            } else {
                System.out.println("Song to play next not found in the playlist.");
            }
        }
    }



    public void addmiddle(int index, String song) {
        node temp = this.head;
        for (int i = 0; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        node newnode = new node(song);
        newnode.next = temp.next;
        newnode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newnode;
        } else {
            this.tail = newnode;
        }
        temp.next = newnode;
    }


    public void recentlyplayed(){
        this.playhistory.recentlyplayed();
    }

    public void History(){
        this.playhistory.printHistory();
    }

    public void printdata(){
        node temp = this.head;
        while(temp.next != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

}
