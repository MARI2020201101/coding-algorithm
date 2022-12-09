package ds.binarytree.inorder;

import java.util.List;

class ReconstructPreOrder {
    static int subtreeIdx = 0;

    static Node reconstructPreOrder(List<Integer> preOrder){
        return reconstructPreOrderHelper(preOrder);
    }

    private static Node reconstructPreOrderHelper(List<Integer> preOrder) {
        Integer data = preOrder.get(subtreeIdx);
        ++subtreeIdx;
        if(data == null){
            return null;
        }
        Node left = reconstructPreOrder(preOrder);
        Node right = reconstructPreOrder(preOrder);
        return new Node(data, left, right);
    }
}
