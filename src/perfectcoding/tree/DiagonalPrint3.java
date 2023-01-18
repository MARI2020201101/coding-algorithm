package perfectcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DiagonalPrint3 {
    public static void main(String[] args) {
        Node root = new Node(8, new Node(3, new Node(1),null), new Node(10
                , new Node(6 , new Node(4), new Node(7)), new Node(14, new Node(13), null)));
        List<List<Integer>> results = diagonalPrint(root);
        System.out.println(results);
    }
    static List<List<Integer>> diagonalPrint(Node root){
            LinkedList<Node> queue = new LinkedList<>();
            List<List<Integer>> results = new ArrayList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> result = new ArrayList<>();

                while(size-->0) {
                    Node node = queue.removeFirst();
                    while(node != null) {
                        result.add(node.data);
                        if(node.left != null) queue.addLast(node.left);
                        node = node.right;
                    }
                }
                results.add(result);
            }
            return results;
        }

}
