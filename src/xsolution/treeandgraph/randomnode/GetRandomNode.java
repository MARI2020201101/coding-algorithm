package xsolution.treeandgraph.randomnode;

import java.util.Random;

class GetRandomNode {
    public static void main(String[] args) {
        Node root = new Node();
        root.addData(5);
        root.addData(2);
        root.addData(6);
        root.addData(4);
        root.addData(7);
        root.addData(3);
        root.addData(8);
        root.addData(10);
        root.addData(1);

        System.out.println(getRandomNode(root));
    }
    static Node getRandomNode(Node root){
        if(root.size == 0) return root;
        Random random = new Random();
        int idx = random.nextInt(root.size);
        if(idx == root.size){
            return root;
        }else if(idx <= root.size/2){
            return getRandomNode(root.left);
        }else{
            return getRandomNode(root.right);
        }
    }
}
