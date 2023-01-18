package perfectcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DiagonalPrint2 {
    public static void main(String[] args) {
        Node root = new Node(8, new Node(3, new Node(1),null), new Node(10
                , new Node(6 , new Node(4), new Node(7)), new Node(14, new Node(13), null)));
        List<List<Integer>> results = diagonalPrint(root);
        System.out.println(results);
    }
    static List<List<Integer>> diagonalPrint(Node root){
        List<List<Integer>> results = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()){
            Node node = queue.poll();
            List<Integer> result = new ArrayList<>();
            while (node!=null){
                if(node.left!=null){
                    queue.add(node);
                }
                result.add(node.data);
                node = node.right;
            }
            results.add(result);
        }
        return results;
    }
}
