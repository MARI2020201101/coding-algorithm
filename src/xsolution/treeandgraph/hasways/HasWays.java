package xsolution.treeandgraph.hasways;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class HasWays {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        node1.adjacents.add(node2);
        node2.adjacents.add(node3);
        node2.adjacents.add(node4);
        node3.adjacents.add(node4);
        node4.adjacents.add(node5);

        System.out.println(hasWays(node1, node5));
        System.out.println(hasWays(node2, node6));
    }
    static boolean hasWays(Node start, Node end){
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        start.state = State.Visiting;
        while(! queue.isEmpty()){
            Node node = queue.poll();
            if(node == end) return true;
            List<Node> nodes = node.getAdjacents();
            for (Node next : nodes) {
                if(next.state == State.Unvisited){
                    next.state = State.Visiting;
                    queue.add(next);
                }
            }
            node.state = State.Visited;
        }
        return false;
    }
}
