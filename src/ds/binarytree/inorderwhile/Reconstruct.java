package ds.binarytree.inorderwhile;

import java.util.ArrayList;
import java.util.List;

class Reconstruct {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(43);
        list.add(23);
        list.add(37);
        list.add(29);
        list.add(31);
        list.add(41);
        list.add(47);
        list.add(53);
        System.out.println(reconstruct(list));
    }
    static Node reconstruct(List<Integer> preorder){
        return reconstruct(preorder, 0, preorder.size());
    }

    private static Node reconstruct(List<Integer> preorder, int preStart, int preEnd) {
        if(preStart >= preEnd){
            return null;
        }
        Integer rootData = preorder.get(preStart);
        Integer transitPoint = preStart + 1 ;
        while(transitPoint < preorder.size() && preorder.get(transitPoint) < rootData){
            transitPoint++;
        }
        return new Node(rootData,
                reconstruct(preorder, preStart+1, transitPoint),
                reconstruct(preorder, transitPoint+1, preEnd));
    }
}
