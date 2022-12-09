package ds.binarytree.inorder;

import java.util.ArrayList;
import java.util.List;

class InOrderTraversal {
    static List<Integer> inorder(Node root){
        Node prev = null;
        Node curr = root;
        List<Integer> result = new ArrayList<>();
        while(curr != null){
            Node next = null;
            if(curr.left!=null){
                next = curr.left;
            }else if(curr.right == null && prev.left == curr){
                result.add(curr.data);
                next = curr.parent;

            }else{
                next = curr.parent;
            }
            prev = curr;
            curr = next;

        }
        return result;
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}