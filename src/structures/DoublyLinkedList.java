package structures;

public class DoublyLinkedList {
    
    private Node firstNode = null;
    private Node lastNode = null;

    private Integer size = 0;

    public DoublyLinkedList() { }

    public void addLast(Long num){
        Node newNode = new Node(num);
        newNode.setNext(null);
        newNode.setPrevious(lastNode);

        if(firstNode == null){
            firstNode = newNode;
        }
        if(lastNode != null){
            lastNode.setNext(newNode);
        }

        lastNode = newNode;
        size++;
    }

    public void add(Integer index, Long num){
        Node newNode = new Node(num);

        Node auxiliar = getNode(index);
        newNode.setNext(auxiliar);

        if(newNode.getNext() != null){
            newNode.setPrevious(auxiliar.getPrevious());
            newNode.getNext().setPrevious(newNode);
        } else {
            newNode.setPrevious(lastNode);
            lastNode = newNode;
        }

        if(index==0){
            firstNode = newNode;
        } else {
            newNode.getPrevious().setNext(newNode);
        }

        size++;

    }

    public void remove(int index){
        if(index == 0){
            firstNode = firstNode.getNext();
            if(firstNode != null){
                firstNode.setPrevious(null);
            }
        } else {
            Node auxiliar = getNode(index);
            auxiliar.getPrevious().setNext(auxiliar.getNext());
            if(auxiliar != lastNode){
                lastNode.getNext().setPrevious(auxiliar.getNext());
            } else {
                lastNode = auxiliar;
            }
        }

        size--;
    }

    public int getSize(){
        return this.size;
    }

    public Long getFirstNode() {
        return firstNode.getContent();
    }

    public Long getLastNode() {
        return lastNode.getContent();
    }

    public Node getNode(int index){
        Node auxiliar = firstNode;
        for(int i = 0; i<index && auxiliar!=null; i++){
            auxiliar = auxiliar.getNext();
        }

        return auxiliar;
    }

    @Override
    public String toString() {
        String build = "";
        Node auxiliar = firstNode;

        for(int i = 0; i<getSize(); i++){
            build += "[" + auxiliar.getContent().toString() + "] \u21D4 ";
            auxiliar = auxiliar.getNext();
        }
        build += "null";

        return build;

    }

    
    
}
