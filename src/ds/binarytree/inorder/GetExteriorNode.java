package ds.binarytree.inorder;

import java.util.LinkedList;
import java.util.List;

class GetExteriorNode {
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

        List<Node> exteriorNode = getExteriorNode(root);
        exteriorNode.forEach(n -> System.out.print(n.data+" , "));
    }
    static List<Node> getExteriorNode(Node root){
        List<Node> allExteriors = new LinkedList<>();
        List<Node> leftExteriors = getLeftExteriorNode(root.left, true);
        List<Node> rightExteriors = getRightExteriorNode(root.right, true);
        allExteriors.addAll(leftExteriors);
        allExteriors.addAll(rightExteriors);
        allExteriors.add(root);
        return allExteriors;
    }

    private static List<Node> getLeftExteriorNode(Node node, boolean isBoundary) {
        List<Node> nodes = new LinkedList<>();
        if(node != null && (isBoundary || isLeafNode(node))){
            nodes.add(node);
            return nodes;
        }
        List<Node> leftExteriors = getLeftExteriorNode(node.left, isBoundary);
        List<Node> rightExteriors = getLeftExteriorNode(node.right, isBoundary&&node.left == null);
        nodes.addAll(leftExteriors);
        nodes.addAll(rightExteriors);
        return nodes;

    }
    private static List<Node> getRightExteriorNode(Node node, boolean isBoundary) {
        List<Node> nodes = new LinkedList<>();
        if(node != null && (isBoundary || isLeafNode(node))){
            nodes.add(node);
            return nodes;
        }
        List<Node> leftExteriors = getRightExteriorNode(node.left, isBoundary&& node.right == null);
        List<Node> rightExteriors = getRightExteriorNode(node.right, isBoundary);
        nodes.addAll(leftExteriors);
        nodes.addAll(rightExteriors);
        return nodes;

    }

    private static boolean isLeafNode(Node node) {
        return node.left == null && node.right==null;
    }
}
