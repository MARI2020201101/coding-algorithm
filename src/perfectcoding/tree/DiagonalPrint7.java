package perfectcoding.tree;

import java.util.LinkedList;
import java.util.Queue;

class DiagonalPrint7 {
    public static void main(String[] args) {
        Node root = new Node(8, new Node(3, new Node(1),null), new Node(10
                , new Node(6 , new Node(4), new Node(7)), new Node(14, new Node(13), null)));
        print(root);
    }
    static void print(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node dummy = new Node(null);
        while(root!=null){
            queue.add(root);
            root = root.right;
        }
        queue.add(dummy);

        while(queue.size()!=1){
            Node front =  queue.poll();
            if(front!=dummy){
                System.out.print(front.data + " ");
                Node node = front.left;
                while(node!=null){
                    queue.add(node);
                    node = node.right;
                }
            }else{
                queue.add(dummy);
                System.out.println();
            }
        }
    }
}
