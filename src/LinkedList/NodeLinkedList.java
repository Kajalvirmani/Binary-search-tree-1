package LinkedList;

public class NodeLinkedList {
    public int data;

    public NodeLinkedList next;
    NodeLinkedList head;

    NodeLinkedList(int value){
        this.data= value;
        this.next= null;
        this.head= null;
    }
}
