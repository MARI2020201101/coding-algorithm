package ds.binarytree.lca;

class LCAV2 {
    static Status lca(Node root, Node node1, Node node2){
        if(root == null){
            return new Status(0,null);
        }

        Status leftResult = lca(root.left, node1, node2);
        Status rightResult = lca(root.right, node1, node2);

        if(leftResult.numTargetNodes == 2 && leftResult.ancestor!=null){
            return leftResult;
        }else if(rightResult.numTargetNodes == 2 && rightResult.ancestor != null){
            return rightResult;
        }

        Node next = null;
        if(root == node1 || root == node2 ){
            next = root;
        }
        int nextNumTarget = leftResult.numTargetNodes + rightResult.numTargetNodes + (next!=null ? 1 : 0);

        return new Status(nextNumTarget, next);
    }
}
