package xsolution.treeandgraph.successor;

class InOrderSuccessor {
    static Node inOrderSuccessor(Node node){
        if(node.right!=null){
            return findMostLeftRightChild(node.right);
        }

        Node parent = node.parent;
        while(parent != null && node != parent.left){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static Node findMostLeftRightChild(Node node) {
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
}
