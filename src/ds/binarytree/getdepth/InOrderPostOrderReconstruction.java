package ds.binarytree.getdepth;

class InOrderPostOrderReconstruction {
    public static void main(String[] args) {
        int[] inOrder = {4,2,5,1,6,3,7};
        int[] postOrder = {4,5,2,6,7,3,1};
        Node root = reconstruct(inOrder, postOrder, 0, 6);
        System.out.println(root);
    }
    static int idx = 6;
    static Node reconstruct(int[] inOrder, int[] postOrder, int left, int right){
        if(left == right){
            return new Node(inOrder[idx]);
        }
        int rootData = postOrder[idx--];
        Node root = new Node(rootData);
        int rootIdx = find(inOrder, rootData);
        System.out.println(String.format("rootData=%d, rootIdx=%d, left=%d, right=%d",rootData,rootIdx, left, right));
        root.left = reconstruct(inOrder, postOrder, left, rootIdx - 1);
        root.right = reconstruct(inOrder, postOrder, rootIdx+1, right);

        return root;
    }
    static int find(int[] inOrder, int n){
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == n) return i;
        }
        return -1;
    }
}
