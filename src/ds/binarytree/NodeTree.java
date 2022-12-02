package ds.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

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

        String serialize2 = nodeTree.serialize(root, new StringBuffer());
        System.out.println(serialize2);
    }
}
class NodeTree {
    Node root;

    public Node deserialize(String str){
        String[] strs = str.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : strs){
            nodes.addLast(s);
        }

        return deserialize(nodes);
    }

    private Node deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;
        String node = nodes.removeFirst();
        if(node.equals("#")) return null;
        root = new Node(Integer.parseInt(node));
        root.left = deserialize(root, nodes);
        root.right = deserialize(root, nodes);

        return root;
    }

    private Node deserialize(Node root, LinkedList<String> nodes) {
        String node = nodes.removeFirst();
        if(node.equals("#")) return null;
        root = new Node(Integer.parseInt(node));
        root.left = deserialize(root, nodes);
        root.right = deserialize(root, nodes);
        return root;
    }

    public String serialize(){
        StringBuffer sb = new StringBuffer();
        return serialize(root, sb);
    }

    public String serialize(Node root, StringBuffer sb) {
        if(root==null){
            sb.append("#");
            sb.append(",");
            return sb.toString();
        }
        sb.append(root.data);
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
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
