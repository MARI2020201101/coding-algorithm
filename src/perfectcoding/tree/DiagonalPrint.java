package perfectcoding.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class DiagonalPrint {
    public static void main(String[] args) {
        Node root = new Node(8, new Node(3, new Node(1),null), new Node(10
        , new Node(6 , new Node(4), new Node(7)), new Node(14, new Node(13), null)));
        List<Integer> result = new ArrayList<>();
        diagonalPrint(root, result);
        System.out.println(result);

    }
    static void diagonalPrint(Node node, List<Integer> result){
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(! stack.isEmpty()){
            Node curr = stack.pop();
            result.add(curr.data);
            if(curr.left != null){
                stack.add(curr.left);
            }else if(curr.right != null){
                stack.add(curr.right);
            }


        }


        Collections.reverse(result);
    }
}
