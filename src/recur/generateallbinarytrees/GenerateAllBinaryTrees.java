package recur.generateallbinarytrees;

import java.util.ArrayList;
import java.util.List;

class GenerateAllBinaryTrees {
    public static void main(String[] args) {
        List<Node> nodes = generateAllBinaryTrees(3);
        nodes.forEach(System.out::println);
    }
    static List<Node> generateAllBinaryTrees(int num){
        List<Node> nodes = new ArrayList<>();
        if(num == 0){
            nodes.add(null);
            return nodes;
        }
        for (int i = 0; i < num; i++) {
            int leftNodesNum = i;
            int rightNodesNum = num - i-1;
            List<Node> lefts = generateAllBinaryTrees(leftNodesNum);
            List<Node> rights = generateAllBinaryTrees(rightNodesNum);
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    nodes.add(new Node(
                            0
                            ,lefts.get(j)
                            ,rights.get(k)));
                }
            }

        }
        return nodes;
    }

}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}