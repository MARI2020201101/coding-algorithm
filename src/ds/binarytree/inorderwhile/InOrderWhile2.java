package ds.binarytree.inorderwhile;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class InOrderWhile2 {
    public static void main(String[] args) {
        List<Integer> inorder = inorder(sampleNode());
        inorder.forEach(System.out::println);
    }
    static List<Integer> inorder(Node root){
        Deque<Node> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.addFirst(root);
        while(! stack.isEmpty()){
            Node node = stack.removeFirst();
            if(node!=null){
                result.add(node.data);
                stack.addFirst(node.right);
                stack.addFirst(node.left);
            }
        }
        return result;
    }
    static Node sampleNode(){
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node left2 = new Node(3);
        Node right1 = new Node(4);
        Node right2 = new Node(5);
        root.left = left1;
        left1.left = left2;
        left1.right = right1;
        root.right = right2;
        return root;
    }
}
