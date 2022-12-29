package ds.binarytree.getdepth;

class InAndPost {
    public static void main(String[] args) {
        int[] inOrder = {4,2,7,5,1,3,6};
        int[] postOrder = {4,7,5,2,6,3,1};
        Node root = reconstruct(inOrder, postOrder);
        System.out.println(root);
    }
    static Node reconstruct(int[] inOrder, int[] postOrder){
        return reconstruct(inOrder, postOrder, 0, inOrder.length-1, 0, postOrder.length-1);
    }

    private static Node reconstruct(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart
            , int postEnd) {
        if(inStart > inEnd){
            return null;
        }
        if(inStart == inEnd){
            return new Node(inOrder[inStart]);
        }

        int rootData = postOrder[postEnd];
        int inOrderRootIdx = find(inOrder, rootData);
        int leftSize = inOrderRootIdx - inStart;

        Node root = new Node(rootData);
        root.left = reconstruct(inOrder, postOrder, inStart, inOrderRootIdx-1, postStart, postStart + leftSize-1);
        root.right = reconstruct(inOrder, postOrder, inOrderRootIdx+1, inEnd, postStart + leftSize, postEnd-1);

        return root;
    }
    static int find(int[] inOrder, int n){
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == n) return i;
        }
        return -1;
    }
}
