package perfectcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DiagonalPrint5 {
    static Node dummy = new Node(null);
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
            queue.add(dummy);
            Node node = root;
            List<Integer> result = new ArrayList<>();
            while(queue.size() != 1){

                if(node != dummy){
                    node = queue.remove();
                    System.out.println(node);
                    while (node!=null){
                        result.add(node.data);
                        queue.add(node.left);
                        node = node.right;
                    }

                }else{
                    results.add(new ArrayList<>(result));
                    result = new ArrayList<>();
                    queue.add(dummy);
                }

            }

            return results;
        }

}
