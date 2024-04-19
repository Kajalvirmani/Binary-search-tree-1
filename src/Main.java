import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int[] arr= {2,5,1,4,7};
        binarySearcOperations(arr);

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
//        binarySearchTree.inorder(rootValue);
//        System.out.println("   ");
//        binarySearchTree.postOrder(rootValue);
//        System.out.println("   ");
////        binarySearchTree.inOrderTraversal(rootValue);
//        boolean result=binarySearchTree.searchTree(3,rootValue);
//        if(result){
//            System.out.println("value found");
//        }
//        else{
//            System.out.println("value not found");
//        }
//        Node temp=binarySearchTree.deleteValue(5,rootValue);
//        binarySearchTree.inorder(temp);
        ArrayList<Integer> result= binarySearchTree.findKSmallestElements(rootValue,3);
        System.out.println(result);
    }



}

