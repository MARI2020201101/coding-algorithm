package ds.binarytree.getdepth;

class InOrderPostOrderReconstructionV2 {
    public static void main(String[] args) {
        int[] inOrder = {4,2,5,1,6,3,7};
        int[] postOrder = {4,5,2,6,7,3,1};
        Node root = reconstruct(6, inOrder, postOrder, 0, 6);
    }

    static Node reconstruct(int curr, int[] inOrder, int[] postOrder, int left, int right){
        if(left == right){
            return new Node(inOrder[curr]);
        }
        int rootData = postOrder[curr];
        Node root = new Node(rootData);
        int rootIdx = find(inOrder, rootData);

        System.out.println(String.format("rootData=%d, rootIdx=%d, left=%d, right=%d",rootData,rootIdx, left, right));
        root.left = reconstruct(rootIdx-1, inOrder, postOrder, left, rootIdx - 1);
        root.right = reconstruct(rootIdx+1, inOrder, postOrder, rootIdx+1, right);

        return root;
    }
    static int find(int[] inOrder, int n){
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == n) return i;
        }
        return -1;
    }
}
