package structures;

public class Node {
    
    private Integer content;

    private Node previous;
    private Node next;
    
    public Node(Integer content) {
        this.content = content;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
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
