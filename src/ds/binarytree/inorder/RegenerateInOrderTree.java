package ds.binarytree.inorder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RegenerateInOrderTree {
    static Node regenerateInOrderTree(List<Integer> preOrder, List<Integer> inOrder){
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inOrderIndexMap.put(inOrder.get(i), i);
        }
        return regenerateInOrderTreeHelper(
                preOrder, 0, preOrder.size(), inOrder, 0, inOrder.size(), inOrderIndexMap
        );
    }

    private static Node regenerateInOrderTreeHelper(
            List<Integer> preOrder, int preOrderStart, int preOrderEnd
            , List<Integer> inOrder, int inOrderStart, int inOrderEnd
            , Map<Integer, Integer> inOrderIndexMap) {
        if(preOrderEnd<=preOrderStart || inOrderEnd<=inOrderStart){
            return null;
        }
        Integer rootInorderIdx = inOrderIndexMap.get(preOrder.get(preOrderStart));
        int leftSubtreeSize = rootInorderIdx - inOrderStart;

        return new Node(
                preOrder.get(preOrderStart),
                regenerateInOrderTreeHelper(preOrder
                        , preOrderStart+1, preOrderStart+1+leftSubtreeSize
                        , inOrder
                        , inOrderStart, rootInorderIdx, inOrderIndexMap),
                regenerateInOrderTreeHelper(preOrder
                        , preOrderStart+1+leftSubtreeSize, preOrderEnd
                        ,inOrder
                        , rootInorderIdx+1, inOrderEnd, inOrderIndexMap)
        );
    }
}
