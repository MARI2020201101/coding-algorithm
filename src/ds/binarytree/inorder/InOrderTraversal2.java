package ds.binarytree.inorder;

import java.util.ArrayList;
import java.util.List;

class InOrderTraversal2 {
    static List<Integer> inorder(Node root){
        Node prev = null;
        Node curr = root;
        List<Integer> result = new ArrayList<>();
        while(curr != null){
            Node next = null;
            if(curr.parent == prev){
                if(curr.left != null){
                    next = curr.left;
                }else{
                    result.add(curr.data);
                    next = curr.right==null? curr.parent : curr.right;
                }
            }else if(curr.left == prev){
                result.add(curr.data);
                next = curr.right==null? curr.parent : curr.right;
            }else{
                next = curr.parent;
            }
            prev = curr;
            curr = next;

        }
        return result;
    }
}

