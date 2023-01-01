package ds.binarytree.preorderwhile;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderWhile {
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
        List<Integer> list = preOrder(root);
        list.forEach(System.out::println);
    }
    static List<Integer> preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(! stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.data);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left!= null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}