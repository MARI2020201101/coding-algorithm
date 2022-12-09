package ds.binarytree.lca;

class LCA {
    public static Node lca(Node root, Node target1, Node target2){
        return lcaStatus(root, target1, target2).ancestor;
    }
    private static Status lcaStatus(Node root, Node target1, Node target2){
        if(root == null){
            return new Status(0,null);
        }

        Status lStatus = lcaStatus(root.left, target1, target2);
        if(lStatus.numTargetNodes == 2 ){
            return lStatus;
        }
        Status rStatus = lcaStatus(root.right, target1, target2);
        if(rStatus.numTargetNodes == 2){
            return rStatus;
        }
        int inLeft = root == target1 ? 1 : 0;
        int inRight = root == target2 ? 1 : 0;

        int numTargetCount = lStatus.numTargetNodes + rStatus.numTargetNodes
                + inLeft + inRight;
        Node isAncestor = numTargetCount == 2 ? root : null;
        return new Status(numTargetCount, isAncestor);
    }

}
class Status{
    int numTargetNodes;
    Node ancestor;

    public Status(int numTargetNodes, Node ancestor) {
        this.numTargetNodes = numTargetNodes;
        this.ancestor = ancestor;
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}