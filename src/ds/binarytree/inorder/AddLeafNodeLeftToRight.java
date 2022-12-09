package ds.binarytree.inorder;

import java.util.LinkedList;
import java.util.List;

class AddLeafNodeLeftToRight {
    static List<Node> createListOfLeaves(Node root){
        List<Node> leaves = new LinkedList<>();
        addLeavesToRight(root, leaves);
        return leaves;
    }

    private static void addLeavesToRight(Node root, List<Node> leaves) {
        Node node = root;
        if(node!=null){
            if(node.left==null && node.right==null){
                leaves.add(node);
            }else{
                addLeavesToRight(node.left, leaves);
                addLeavesToRight(node.right, leaves);
            }
        }
    }
}
