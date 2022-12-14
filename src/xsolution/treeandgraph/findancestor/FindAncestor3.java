package xsolution.treeandgraph.findancestor;

class FindAncestor3 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;
        node4.left = node8;
        node4.right = node9;
        node8.parent = node4;
        node9.parent = node4;
        node5.left = node10;
        node5.right = node11;
        node10.parent = node5;
        node11.parent = node5;
        node7.left = node12;
        node7.right = node13;
        node12.parent = node7;
        node13.parent = node7;
        node11.left = node14;
        node11.right = node15;
        node14.parent = node11;
        node15.parent = node11;

        Node lca = find(root, node10, node15);
        Node lca2 = find(root, node8, node15);
        System.out.println(lca);
        System.out.println(lca2);

    }
    static Node find(Node root, Node node1, Node node2){
        return __find(root,node1,node2).node;
    }
    static Result __find(Node root, Node node1, Node node2){
        if(root == null) return new Result(null, false);
        else if(root == node1 && root == node2) return new Result(root, true);

        Result left = __find(root.left, node1, node2);
        Result right = __find(root.right, node1, node2);

        if(left.node!=null && right.node!=null && left.isCommon && right.isCommon){
            return new Result(root, true);
        }else if(root == node1 || root == node2){
            return new Result(root, true);
        }else if(left.node!=null || right.node!=null){
            Node node = left.node==null? right.node : left.node;
            boolean nextCommon = left.node==null? right.isCommon : left.isCommon;
            return new Result(node, nextCommon);
        }
        return new Result(null, false);
    }
}
class Result {
    Node node;
    boolean isCommon;

    public Result() {
    }

    public Result(Node node, boolean isCommon) {
        this.node = node;
        this.isCommon = isCommon;
    }
}