package perfectcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SpiralPrint {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4
        , new Node(8), new Node(9)) , new Node(5 , new Node(10), new Node(11)))
                , new Node(3, new Node(6
        , new Node(12), new Node(13)) , new Node(7 , new Node(14), new Node(15))));
        List<Integer> result = print(root);
        System.out.println(result);
    }
    static List<Integer> print(Node root){

        List<Integer> result = new ArrayList<>();
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int flip = 0;
        while(! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                result.add(node.data);
                if((flip & 1)==1){
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }else{
                    if(node.right != null){
                        queue.add(node.right);
                    }
                    if(node.left != null){
                        queue.add(node.left);
                    }
                }
            }
            flip^=1;
        }
        return result;
    }
}
