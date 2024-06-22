import java.util.ArrayList;
import java.util.Map;

import Graphs.Graph;
import  LinkedList.NodeLinkedList;
import LinkedList.LinkedList;
import Stack.StackOperations;

public class Main {

    public static void main(String[] args) {

        int[] arr= {2,5,1,4,7};
        binarySearcOperations(arr);
        linkedListOperations(arr);
        graphOperations(arr);
        stackOperations(arr);
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

    public static void graphOperations(int[] arr){
        Graph g = new Graph();
        for (int i = 0; i < arr.length; i++) {
            g.addVertex(arr[i]);
        }
        g.addEdges(2,1);
        g.addEdges(4,2);
        g.addEdges(4,1);
        g.addEdges(4,5);
        g.addEdges(5,1);
        g.addEdges(5,7);

        g.getVertexCount();
        g.getEdgeCount();
       Boolean found= g.implementBFS(5, arr);
       if(found){
           System.out.println(" found ");
       }
       else{
           System.out.println(" not found ");
       }

        Boolean foundDFS= g.implementDFS(5);
        if(foundDFS){
            System.out.println(" found ");
        }
        else{
            System.out.println(" not found ");
        }
    }

    public static void stackOperations(int[] arr){
        StackOperations s= new StackOperations();
        Map<Integer,Integer> i= s.nextBiggerNumber(arr);
        i.forEach((k,v)->
                System.out.println(" key "+ k+" value "+ v ));
        Map<Integer,Integer> nextBiggerElement= s.findNextBiggerNumber(arr);
        nextBiggerElement.forEach((k,v)->
            System.out.println(" key "+ k+" value "+ v ));

        ArrayList<Integer> countSmallerContiguousNumbers= s.findStockSmallerSpan(arr);
        countSmallerContiguousNumbers.forEach(ele->
                System.out.println("count of numbers smaller than current number in an array for this ele "+ ele ));

    }

}

