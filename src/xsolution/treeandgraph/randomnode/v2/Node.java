package xsolution.treeandgraph.randomnode.v2;

import java.util.Random;
class Demo {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.insertData(2);
        root.insertData(6);
        root.insertData(4);
        root.insertData(3);
        root.insertData(8);
        root.insertData(10);
        root.insertData(7);
        root.insertData(1);
        System.out.println("root ->"+root);

        System.out.println(root.getRandomNode());
    }

}
class Node {
    Integer data;
    Node left;
    Node right;
    Integer size;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", size=" + size +
                '}';
    }

    public Node(Integer d){
        this.data = d;
        this.size = 1;
    }
    public Node getRandomNode(){
        Random random = new Random();
        int idx = random.nextInt(size)+1;
        int leftSize = left == null ? 0 : left.size;
        System.out.println("idx = "+idx + ", leftsize = "+leftSize);
        if(idx <= leftSize){
            return left.getRandomNode();
        }else if(idx == leftSize+1){
            return this;
        }else{
            return right.getRandomNode();
        }
    }
    public void insertData(Integer d){
        if(data ==  d) return;
        if(data > d){
            if(left == null){
              left = new Node(d);
            }else{
               left.insertData(d);
            }
        }else{
            if(right == null){
                right = new Node(d);
            }else{
                right.insertData(d);
            }
        }
        size++;
    }
    public Node find(Integer d){
        if(d == data) return this;
        else if(d < data){
            return left == null ? null : left.find(d);
        }else {
            return right == null ? null : right.find(d);
        }
    }
}
