package ds.binarytree;

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
    }
}
class NodeTree {
    Node root;

    public String serialize(){
        StringBuffer sb = new StringBuffer();
        return serialize(root, sb);
    }

    private String serialize(Node root, StringBuffer sb) {
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
