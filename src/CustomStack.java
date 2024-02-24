public class CustomStack {
    private Node top;
    private int size;

    private static class Node {
        String data;
        Node prev;

        Node(String data) {
            this.data = data;
            this.prev = null;
        }
    }

    public CustomStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;
        size++;
    }

    public void pop(){
        if(this.top == null){
            System.out.println("playlist empty");
        }
        else{
            this.top = this.top.prev;
            size--;

        }
    }

    public String recentlyplayed(){
        if(this.top == null){
            System.out.println("playlist empty");
            return null;
        }
        else{
            return this.top.data;
        }
    }
    public void printHistory() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public String peek(){
        return this.top.data;
    }

    public void clearHistory() {
        top = null;
        size = 0;
        System.out.println("History cleared.");
    }
    public int getSize(){
        return this.size;
    }

}
