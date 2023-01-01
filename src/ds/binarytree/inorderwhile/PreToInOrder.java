package ds.binarytree.inorderwhile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PreToInOrder {
    static Node preToInOrder(List<Integer> inorder,List<Integer> preorder){
        Map<Integer,Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            inorderIdx.put(inorder.get(i), i);
        }
        return preToInOrder(inorder, 0, inorder.size(), preorder, 0, preorder.size(), inorderIdx);
    }

    private static Node preToInOrder(List<Integer> inorder, int inStart, int inEnd, List<Integer> preorder, int preStart, int preEnd, Map<Integer, Integer> inorderIdx) {
        if(inStart >= inEnd || preStart >= preEnd){
            return null;
        }

        int rootIdx = inorderIdx.get(preorder.get(preStart));
        int leftSize = rootIdx - inStart;

        return new Node(
                preorder.get(preStart),
                preToInOrder(inorder, inStart, rootIdx, preorder, preStart+1,preStart +1 + leftSize, inorderIdx),
                preToInOrder(inorder, rootIdx+1, inEnd, preorder, preStart+1+leftSize, preEnd, inorderIdx)
        );
    }
}
