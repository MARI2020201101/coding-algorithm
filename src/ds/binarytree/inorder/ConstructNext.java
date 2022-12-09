package ds.binarytree.inorder;

class ConstructNext {
    static void constructNext(Node root){
        Node node = root;
        while(node!=null && node.left!=null){
            populateLowerLevelNext(node);
            node = node.left;
        }
    }

    private static void populateLowerLevelNext(Node node) {
        Node iter = node;
        while(iter!=null){
                iter.left.next = iter.right;
             if(iter.next!=null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }
}
