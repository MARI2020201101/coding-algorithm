package ds.binarytree.balanced;

import static ds.binarytree.balanced.BalanceStatusWithHeight.isBalanced;

class Demo {
    public static void main(String[] args) {
        NodeTree nodeTree = new NodeTree();
        nodeTree.putNode(5);
//        nodeTree.putNode(0);
//        nodeTree.putNode(1);
        nodeTree.putNode(2);
        nodeTree.putNode(3);
        nodeTree.putNode(4);
        nodeTree.putNode(6);
        nodeTree.putNode(7);
        nodeTree.putNode(8);

        boolean balanced = isBalanced(nodeTree.root);
        System.out.println(balanced);
    }

}

class BalanceStatusWithHeight {
    public boolean balanced;
    public int height;

    @Override
    public String toString() {
        return "BalanceStatusWithHeight{" +
                "balanced=" + balanced +
                ", height=" + height +
                '}';
    }

    public BalanceStatusWithHeight(boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }
    public static boolean isBalanced(Node root){
        return isBalancedCheck(root).balanced;
    }
    private static BalanceStatusWithHeight isBalancedCheck(Node root){
        if(root==null){
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftBalance = isBalancedCheck(root.left);
        if(! leftBalance.balanced){
            return leftBalance;
        }
        BalanceStatusWithHeight rightBalance = isBalancedCheck(root.right);
        if(! rightBalance.balanced){
            return rightBalance;
        }
        boolean lrBalanced = Math.abs(leftBalance.height - rightBalance.height) <= 1;
        int rootHeight = Math.max(leftBalance.height, rightBalance.height) + 1;
        return new BalanceStatusWithHeight(lrBalanced, rootHeight);
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
class NodeTree {
    Node root;

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