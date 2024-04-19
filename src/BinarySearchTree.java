import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private int counter = 0;


    public Node insertionInBinarySearchTree(int value, Node root) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (value > root.value) {
            root.right = insertionInBinarySearchTree(value, root.right);
        } else {
            root.left = insertionInBinarySearchTree(value, root.left);
        }
        return root;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        } else {
            inorder(node.left);
            System.out.print(node.value);
            inorder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value);
        }
    }

    public Boolean searchTree(int value, Node root) {
        if (root == null) {
            return false;
        } else if (value < root.value) {
            return searchTree(value, root.left);
        } else if (root.value == value) {
            return true;
        } else if (value > root.value) {
            return searchTree(value, root.right);
        } else {
            return false;
        }
    }

    public Node deleteValue(int value, Node root) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = deleteValue(value, root.left);
            return root;
        }
        if (value > root.value) {
            root.right = deleteValue(value, root.right);
            return root;
        }

        if (root.right == null && root.left == null) {
            return null;
        }
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        }
        if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        Node temp = root.left;
        root = findNextSmallestNode(root.right);
        root.left = temp;
        System.out.println(root.value + "f");
        return root;
    }

    public Node findNextSmallestNode(Node n) {
        System.out.println("inside function");
        if (n.left == null) {
            return n;
        } else {
            return findNextSmallestNode(n.left);
        }

    }

   public ArrayList<Integer> findKSmallestElements(Node root,int k){
        ArrayList<Integer> result= new ArrayList<>();
        inOrderTraversalForSmallestElements(root, result,k);
        return result;
   }
   public void inOrderTraversalForSmallestElements(Node root,ArrayList<Integer> result,int k) {

        if(root== null){
            return;
        }
        inOrderTraversalForSmallestElements(root.left, result, k);
       if(result.size()>=k  ){
           return;
       }
        else{
            result.add(root.value);
        }
        inOrderTraversalForSmallestElements(root.right,result,k);
    }



















































































































































































































































































































    public Node inOrderTraversal(Node root) {
        if (root == null) {
            return null;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value);
        System.out.print(" ");
        inOrderTraversal(root.right);
        return null;
    }

}
