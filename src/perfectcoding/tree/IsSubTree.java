package perfectcoding.tree;

class IsSubTree {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5))
                , new Node(3, new Node(6), new Node(7)));
        Node another = new Node(2, new Node(4), new Node(5));
        System.out.println(isSubTree(root, another));
    }
    static boolean isSubTree(Node node, Node another){
        if(node == null && another == null){
            return true;
        }else if(node == null || another == null){
            return false;
        }
        else if(node.data == another.data){
            return isSubTree(node.left, another.left) && isSubTree(node.right, another.right);
        }
        return isSubTree(node.left , another) || isSubTree(node.right, another);
    }
}
