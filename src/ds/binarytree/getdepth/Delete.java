package ds.binarytree.getdepth;

class Delete {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(7);

        root.left = node1;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        delete(root, root, 3);
        System.out.println(root);
    }

    static boolean delete(Node parent, Node root, Integer data){
        if(root == null) return true;
        if(root.data == data){
            if(root.left == null && root.right == null){
                root.data = null;
                parent.left = null;
                parent.right = null;
                return true;
            }else if(root.right != null){
                parent.right = root.right;
                root.data = null;
                return true;
            }else{
                parent.right = getRightMostLeftChild(root);
                root.data = null;
                return true ;
            }
        }
        if(! delete(root, root.left, data)){
            delete(root, root.right, data);
        }
        return false;
    }

    private static Node getRightMostLeftChild(Node root) {
        Node parent = root;
        Node curr = root;
        while(curr!=null && parent.left==curr){
            parent = curr;
            curr = root.left;
        }
        return curr;
    }
}
