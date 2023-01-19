package perfectcoding.tree;

import java.util.ArrayDeque;
import java.util.Queue;

class DiagonalPrint8 {
    static void print(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        Node dummy = new Node(null);

        while(root!=null){
            queue.add(root);
            root = root.right;
        }
        queue.add(dummy);

        while(queue.size()!=1){
            Node front = queue.poll();

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
