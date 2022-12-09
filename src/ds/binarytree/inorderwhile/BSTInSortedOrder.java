package ds.binarytree.inorderwhile;

import java.util.*;

class BSTInSortedOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node left2 = new Node(3);
        Node right1 = new Node(4);
        Node right2 = new Node(5);
        root.left = left1;
        left1.left = left2;
        left1.right = right1;
        root.right = right2;
        List<Integer> list = bstInorder(root);
        list.forEach(System.out::println);
    }
    static List<Integer> bstInorder(Node root){
        List<Integer> result = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while(! queue.isEmpty()){
            Node node = queue.pollFirst();
            if(node.left != null){
                queue.addFirst(node.left);
            }else{
                result.add(node.data);
                if(node.right != null){
                    queue.addFirst(node.right);
                }
            }
        }
        return result;
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}