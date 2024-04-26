import java.util.ArrayList;
import  LinkedList.NodeLinkedList;
import LinkedList.LinkedList;

public class Main {

    public static void main(String[] args) {

        int[] arr= {2,5,1,4,7};
        binarySearcOperations(arr);
        linkedListOperations(arr);

    }

    public static void binarySearcOperations(int[] arr){
        BinarySearchTree binarySearchTree= new BinarySearchTree();


        Node rootValue=null;
        for (int i = 0; i < arr.length; i++) {

            if(i==0){
                rootValue= binarySearchTree.insertionInBinarySearchTree(arr[0],null);
            }
            else{
                binarySearchTree.insertionInBinarySearchTree(arr[i],rootValue );
            }
        }
        System.out.println(rootValue);
        binarySearchTree.inorder(rootValue);
        System.out.println("   ");
        binarySearchTree.postOrder(rootValue);
        System.out.println("   ");
        binarySearchTree.inOrderTraversal(rootValue);
        boolean result=binarySearchTree.searchTree(3,rootValue);
        if(result){
            System.out.println("value found");
        }
        else{
            System.out.println("value not found");
        }
        Node temp=binarySearchTree.deleteValue(5,rootValue);
        binarySearchTree.inorder(temp);
        ArrayList<Integer> elements= binarySearchTree.findKSmallestElements(rootValue,3);
        System.out.println(elements);
    }


    public static void linkedListOperations(int[] arr){
        LinkedList linkedList= new LinkedList();
        NodeLinkedList n= null;
        NodeLinkedList returnedValue;
        for (int i = 0; i < arr.length; i++) {

            returnedValue= linkedList.insertNodeAtBeginning(arr[i],n);
            n=returnedValue;

            if(n.next== null){
                System.out.println("empty node");
            }
            System.out.println(" current node"+ n.data);
        }
        System.out.println(n+" current dead");
        linkedList.traverseOnlyLinkedList(n);
        System.out.println("---------------");
        NodeLinkedList lastNode= linkedList.insertNodeAtEnd(999, n);
        System.out.println(lastNode.data+" last node");
        linkedList.traverseOnlyLinkedList(n);
        System.out.println("---------------");
        lastNode.next=n.next.next;
        System.out.println(lastNode.next.data+" last node next");

        Boolean value=linkedList.loopInLinkedList(n);
        if(value){
            System.out.println(" found loop");
        }
        else{
            System.out.println(" loop not found");
        }
    }


}

