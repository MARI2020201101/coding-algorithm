package perfectcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DiagonalPrint6 {
    static Node dummy = new Node(null);
    public static void main(String[] args) {
        Node root = new Node(8, new Node(3, new Node(1),null), new Node(10
                , new Node(6 , new Node(4), new Node(7)), new Node(14, new Node(13), null)));
        diagonalPrint(root);
    }
    static void diagonalPrint(Node root){
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(dummy);
            Node node = root;
            while(queue.size() != 1){
                if(node != dummy){
                    node = queue.remove();
                    while (node!=null){
                        System.out.print(node.data +",");
                        queue.add(node.left);
                        node = node.right;
                    }
                }else{
                    System.out.println();
                    queue.add(dummy);
                }
            }

        }

}
