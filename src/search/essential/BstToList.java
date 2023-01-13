package search.essential;

class BstToList {
    static class HeadAndTail {
        Node head;
        Node tail;

        public HeadAndTail(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    static class Node {
        int data;
        Node left;
        Node right;
    }
    public static Node bstToList(Node tree){
        return bstToListHelper(tree).head;
    }

    private static HeadAndTail bstToListHelper(Node tree) {
        if(tree == null){
            return new HeadAndTail(null, null);
        }

        HeadAndTail left = bstToListHelper(tree.left);
        HeadAndTail right = bstToListHelper(tree.right);

        if(left.tail!=null){
            left.tail.right = tree;
        }
        tree.left = left.tail;

        if(right.head!=null){
            right.head.left =  tree;
        }
        tree.right = right.head;
        return new HeadAndTail(left.head !=null? left.head : tree,
                                right.tail != null ? right.tail :tree);
    }
}
