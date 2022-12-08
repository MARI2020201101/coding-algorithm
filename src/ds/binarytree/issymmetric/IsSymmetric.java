package ds.binarytree.issymmetric;

class IsSymmetric {
    static boolean isSymmetric(Node root){
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(Node left, Node right) {
        if(left == null && right == null){
            return true;
        }
        else if(left!=null && right!=null){
            return left.data == right.data &&
                    isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}