package ds.binarytree.inorder;

import java.util.ArrayList;
import java.util.List;

class InOrder {
    public static void main(String[] args) {
        System.out.println(inorder(sampleNode()));
    }
    static Node sampleNode(){
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node left2 = new Node(3);
        Node right1 = new Node(4);
        Node right2 = new Node(5);
        root.left = left1;
        left1.parent = root;
        left1.left = left2;
        left2.parent = left1;
        left1.right = right1;
        right1.parent = left1;
        root.right = right2;
        right2.parent = root;
        return root;
    }
    static List<Integer> inorder(Node node){
        Node prev = null;
        Node curr = node;
        List<Integer> result = new ArrayList<>();
        while(curr!=null){
            Node next = null;
            if(curr.parent == prev){
                if(curr.left != null){
                    next = curr.left;
                }else{
                    result.add(curr.data);
                    next = curr.right != null ? curr.right : curr.parent;
                }
            }else if(curr.left == prev){
                result.add(curr.data);
                next = curr.right != null ? curr.right : curr.parent;
            }else{
                next = curr.parent;
            }
            prev = curr;
            curr = next;
        }
        return result;
    }
}
