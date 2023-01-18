package perfectcoding.tree;

import java.util.HashMap;
import java.util.Map;

class VerticalSum {
    public static void main(String[] args) {
        Node root = new Node(5, new Node(4, new Node(3), new Node(7)), new Node(9, new Node(8), new Node(6)));
        Map<Integer, Integer> sums = new HashMap<>();
        verticalSum(root, 0, sums);
        sums.forEach((k,v)-> System.out.println(k+ " : " + v));
    }
    static void verticalSum(Node node, int vertical ,Map<Integer, Integer> sums){
        if(node == null) return;
        if(sums.get(vertical) == null){
            sums.put(vertical, node.data);
        }else{
            Integer sum = sums.get(vertical);
            sums.put(vertical, sum + node.data);
        }
        verticalSum(node.left, vertical-1, sums);
        verticalSum(node.right, vertical+1, sums);
    }
}
