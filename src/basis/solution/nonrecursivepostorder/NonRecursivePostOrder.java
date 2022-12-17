package basis.solution.nonrecursivepostorder;


import java.util.*;

public class NonRecursivePostOrder {
    static List<Integer> nonRecursivePostOrder(TreeNode  node){
        List<Integer> list = __nonRecursivePostOrder(node);
        Collections.reverse(list);
        return list;
    }
    static List<Integer> __nonRecursivePostOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode root = node;
        stack.add(root);
        while(! stack.isEmpty()){
            TreeNode start = stack.pop();
            if(start.left!=null){
                stack.add(start.left);
            }
            if(start.right!=null){
                stack.add(start.right);
            }
            result.add(start.data);
        }
        return result;
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}