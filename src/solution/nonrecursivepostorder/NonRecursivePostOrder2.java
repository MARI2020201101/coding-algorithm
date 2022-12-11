package solution.nonrecursivepostorder;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NonRecursivePostOrder2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode left4 = new TreeNode(5);
        TreeNode left5 = new TreeNode(6);
        TreeNode right1 = new TreeNode(7);
        TreeNode right2 = new TreeNode(8);

        root.left = left1;
        left1.left = left2;
        left1.right = left3;
        left3.left = left4;
        left3.right = left5;
        root.right = right1;
        right1.right = right2;
        List<Integer> list = nonRecursivePostOrder(root);
        list.forEach(s-> System.out.print(s + " "));
    }
    static List<Integer> nonRecursivePostOrder(TreeNode  node){
        return __nonRecursivePostOrder(node);
    }
    static List<Integer> __nonRecursivePostOrder(TreeNode node){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> postOrderSequence = new ArrayList<>();
        TreeNode prev = null;
        stack.add(node);
        while(! stack.isEmpty()){
            TreeNode curr = stack.peekFirst();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null){
                    stack.addFirst(curr.left);
                }else if(curr.right!=null){
                    stack.addFirst(curr.right);
                }else{
                    postOrderSequence.add(curr.data);
                    stack.removeFirst();
                }
            }else if(prev == curr.left){
                if(curr.right!=null){
                    stack.addFirst(curr.right);
                }else{
                    postOrderSequence.add(curr.data);
                    stack.removeFirst();
                }
            }else{
                postOrderSequence.add(curr.data);
                stack.removeFirst();
            }
            prev = curr;
        }
        return  postOrderSequence;
    }
}

