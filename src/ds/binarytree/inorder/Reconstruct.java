package ds.binarytree.inorder;

import java.util.*;

class Reconstruct {
    public static void main(String[] args) {
        List<Integer> preOrder = new ArrayList<>();
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(3);
        preOrder.add(4);
        preOrder.add(5);
        preOrder.add(6);
        preOrder.add(7);
        preOrder.add(8);
        preOrder.add(9);
        List<Integer> inOrder = new ArrayList<>();
        inOrder.add(3);
        inOrder.add(2);
        inOrder.add(5);
        inOrder.add(4);
        inOrder.add(6);
        inOrder.add(1);
        inOrder.add(8);
        inOrder.add(7);
        inOrder.add(9);

        Node root = reconstruct(preOrder, inOrder);
        System.out.println(root);
    }
    static Node reconstruct(List<Integer> preOrder, List<Integer> inOrder){
        HashMap<Integer, Integer> inOrderIdx = new HashMap<>();
        for (int i = 0 ; i < inOrder.size() ; i++) {
            inOrderIdx.put(inOrder.get(i), i);
        }
        return reconstruct(preOrder, 0, preOrder.size(), inOrder, 0, inOrder.size(), inOrderIdx);
    }
    static Node reconstruct(List<Integer> preOrder, int preStart, int preEnd,
                            List<Integer> inOrder, int inStart, int inEnd,
                            HashMap<Integer, Integer> inOrderIdx){
        if(preStart >= preEnd || inStart >= inEnd){
            return null;
        }
        Integer rootInOrderIdx = inOrderIdx.get(preOrder.get(preStart));
        Integer leftSize = rootInOrderIdx - inStart;

        return new Node(
                preOrder.get(preStart),
                reconstruct(preOrder, preStart+1, preStart+1+leftSize,
                        inOrder, inStart, rootInOrderIdx, inOrderIdx),
                reconstruct(preOrder, preStart+1+leftSize, preEnd,
                        inOrder, rootInOrderIdx+1, inEnd, inOrderIdx)
        );
    }
}
