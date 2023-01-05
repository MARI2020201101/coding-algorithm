package ds.binarytree.inorder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class ExteriorBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        Node node17 = new Node(17);
        Node node18 = new Node(18);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        node9.left = node16;
        node13.left = node17;
        node14.right = node18;

        List<Node> exteriorNode = exteriorBinaryTree(root);
        exteriorNode.forEach(n -> System.out.print(n.data+" , "));
    }
    static List<Node> exteriorBinaryTree(Node root){
        List<Node> exterior = new LinkedList<>();
        if(root!=null){
            exterior.add(root);
            exterior.addAll(leftBoundaryAndLeaves(root.left, true));
            exterior.addAll(righttBoundaryAndLeaves(root.right, true));
        }
        return exterior;
    }

    private static List<Node> righttBoundaryAndLeaves(Node node, boolean isBoundary) {
        List<Node> result = new LinkedList<>();
        if(node!=null){
            if(isBoundary || isLeaf(node)){
                result.add(node);
            }
            result.addAll(leftBoundaryAndLeaves(node.left, isBoundary && node.right == null));
            result.addAll(leftBoundaryAndLeaves(node.right, isBoundary));
        }
        return result;
    }

    private static boolean isLeaf(Node node) {
        return node.right==null && node.left==null;
    }

    private static List<Node> leftBoundaryAndLeaves(Node node, boolean isBoundary) {
        List<Node> result = new LinkedList<>();
        if(node!=null){
            if(isBoundary || isLeaf(node)){
                result.add(node);
            }
            result.addAll(leftBoundaryAndLeaves(node.left, isBoundary));
            result.addAll(leftBoundaryAndLeaves(node.right, isBoundary && node.left == null));
        }
        return result;
    }
}
