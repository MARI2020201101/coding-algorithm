package ds.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Demo {
    public static void main(String[] args) {
        NodeTree nodeTree = new NodeTree();
        nodeTree.putNode(5);
        nodeTree.putNode(1);
        nodeTree.putNode(2);
        nodeTree.putNode(3);
        nodeTree.putNode(4);
        nodeTree.putNode(6);
        nodeTree.putNode(7);
        nodeTree.putNode(8);
        String serialize = nodeTree.serialize();
        System.out.println(serialize);
        Node root = nodeTree.deserialize(serialize);
        String serialize2 = nodeTree.serialize(root);
        System.out.println(serialize2);

    }
}

class NodeTree {
    Node root;


    public Node deserialize(String str){
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : str.split(",")){
            nodes.addLast(s);
        }
        return deserialize(root, nodes);
    }

    private Node deserialize(Node root, LinkedList<String> nodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            Node node = queue.poll();
            String rootStr = nodes.removeFirst();
            if(rootStr.equals("#")) continue;
            String lStr = nodes.removeFirst();
            String rStr = nodes.removeFirst();
            node = new Node(Integer.parseInt(rootStr));
            if(! lStr.equals("#")){
                node.left= new Node(Integer.parseInt(lStr));
                queue.add(node.left);
            }
            if(! rStr.equals("#")){
                node.right= new Node(Integer.parseInt(rStr));
                queue.add(node.right);
            }
        }
        return root;
    }

    public String serialize(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        StringBuffer sb = new StringBuffer();
        while(! queue.isEmpty()){
            Node node = queue.poll();
            if(node==null){
                sb.append("#");
                sb.append(",");
                continue;
            }
            sb.append(node.data);
            sb.append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }
    public String serialize(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        StringBuffer sb = new StringBuffer();
        while(! queue.isEmpty()){
            Node node = queue.poll();
            if(node==null){
                sb.append("#");
                sb.append(",");
                continue;
            }
            sb.append(node.data);
            sb.append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }


    public Node putNode(int data){
        root = putNode(root, data);
        return root;
    }

    private Node putNode(Node root, int data) {
        if(root==null) {
            root = new Node(data);
            return root;
        }
        if(data == root.data){
            return root;
        }
        else if(data < root.data){
             root.left=putNode(root.left, data);
        }
        else {
             root.right=putNode(root.right, data);
        }
        return root;
    }

}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}
