package ds.binarytree.getdepth;

class GetDepth {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.left = node1;
        node1.left = node2;
        root.right = node3;
        node3.left = node4;
        node4.left = node5;
        int depth = getDepth(root);
        System.out.println(depth);
    }
    public static int getDepth(Node root){
        if(root == null){
            return -1;
        }
        int leftDepth = getDepth(root.left) + 1;
        int rightDepth = getDepth(root.right) +1;

        return Math.max(leftDepth, rightDepth);
    }
}
class Node{
    Integer data;
    Node left;
    Node right;

    public Node(Integer data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}