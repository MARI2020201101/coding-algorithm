package ds.binarytree.inorder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class ExteriorBinaryTree {
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
