package structures;

public class Node {
    
    private Long content;

    private Node previous;
    private Node next;
    
    public Node(Long content) {
        this.content = content;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [content=" + content + ", previous=" + previous + ", next=" + next + "]";
    }

}
