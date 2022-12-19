package xsolution.treeandgraph.findancestor;

class FindAncestor {
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
       node4.parent = node2;
       node5.parent= node2;
       node2.right = node5;
       node3.left = node6;
       node3.right = node7;
       node6.parent = node3;
       node7.parent = node3;
       node4.left =node8;
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

        Node lca = find(node10, node15);
        System.out.println(lca);

    }
    static Node find(Node node1, Node node2){
        Node parent1 = node1.parent;
        while(parent1!=null){
            Node sibling = node1 == parent1.left ? parent1.right : parent1.left;
            if(covers(sibling, node2)) return parent1;
            parent1 = parent1.parent;
        }
        return parent1;
    }
    static boolean covers(Node sibling, Node target){
        if(sibling == null) return false;
        if(sibling == target) return true;
        return covers(sibling.left, target) || covers(sibling.right, target);
    }
}
