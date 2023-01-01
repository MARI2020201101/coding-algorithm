package ds.binarytree.preorderwhile;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PreOrderTraverse {
    public static void main(String[] args) {
        List<Integer> list = preOrder(sampleNode());
        list.forEach(System.out::println);
    }
    static List<Integer> preOrder(Node root){
        //root, left, right
        Deque<Node> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Node node = root;
        while(! stack.isEmpty() || node!=null){
            if(node!=null){
                stack.addFirst(node);
                node = node.right;
            }else{
                Node n = stack.removeFirst();
                result.add(n.data);
                node = n.left;
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
