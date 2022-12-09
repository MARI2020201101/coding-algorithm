package ds.binarytree.inorderwhile;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BSTInSortedOrder2 {
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
        Node curr = root;
        while(! queue.isEmpty() || curr!=null){
            if(curr != null){
                queue.addFirst(curr);
                curr = curr.left;
            }else{
                curr = queue.pollFirst();
                result.add(curr.data);
                curr = curr.right;
            }
        }
        return result;
    }
}
