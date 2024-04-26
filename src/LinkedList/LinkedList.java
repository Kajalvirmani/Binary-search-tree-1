package LinkedList;

public class LinkedList {

    public void insertNodeMiddle(NodeLinkedList currentNode, int value){

        if(currentNode == null){
            return;
        }
        NodeLinkedList node= new NodeLinkedList(value);

        node.next=currentNode.next;

        currentNode.next= node;
    }

    public NodeLinkedList insertNodeAtEnd( int value, NodeLinkedList head){

        NodeLinkedList node= new NodeLinkedList(value);
        if (head == null) {
            System.out.print(node);
            return node;
        }
        else{
            NodeLinkedList lastNode;
            lastNode=traverseLinkedList(head);
            node.next=null;
            lastNode.next= node ;
            return node;
        }
    }
    public NodeLinkedList insertNodeAtBeginning(int value, NodeLinkedList head){
        NodeLinkedList newNode= new NodeLinkedList(value);
        newNode.next= head;
        newNode.data=value;
        head= newNode;
        return  head;
    }

    // Returns te last element of te linked list.
    public NodeLinkedList traverseLinkedList(NodeLinkedList nodeLinkedList){
       while ( nodeLinkedList.next != null){

           nodeLinkedList=nodeLinkedList.next;
       }
        return nodeLinkedList;
    }

    public void traverseOnlyLinkedList(NodeLinkedList nodeLinkedList){
        while ( nodeLinkedList != null){
            System.out.print( nodeLinkedList.data);
            nodeLinkedList=nodeLinkedList.next;
        }
    }

    // Find if a loop exist in te linked list
    public Boolean loopInLinkedList(NodeLinkedList head){
        NodeLinkedList hare= head;
        NodeLinkedList tortoise= head;
        int count =0;
        while (tortoise!= null && hare!= null && hare.next !=null){
            tortoise= tortoise.next;
            System.out.print(" tortoise "+ tortoise.data);
            if (hare.next.next!= null){
                hare= hare.next.next;
                count++;
                System.out.println(" hare "+ hare.data);
                if(hare == tortoise){
                    System.out.print(" loop length "+ count);
                    return true;
                }
            }
        }
        return false;
    }
}
