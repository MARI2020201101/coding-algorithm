package ds.binarytree.getdepth;

class Reconstruction {
    static int[] preOrder = {1,2,3,4,5,6,7,8,9};
    static int[] inOrder = {3,2,5,4,6,1,8,7,9};
    static int rootIdx = 0;

    public static void main(String[] args) {
        Node node = reconstruct(preOrder, inOrder, 0, preOrder.length-1);
        System.out.println(node);
    }

    private static Node reconstruct(int[] preOrder, int[] inOrder, int left, int right) {
        if(left > right) return null;
        Node rootNode = new Node(preOrder[rootIdx++]);
        if(left == right) return rootNode;

        int rootData = preOrder[rootIdx];
        int nextIdx = find(inOrder, rootData);
        rootNode.left = reconstruct(preOrder, inOrder, left, nextIdx-1);
        rootNode.right = reconstruct(preOrder, inOrder, nextIdx+1, right);

        return rootNode;
    }

    static int find(int[] inOrder, int n){
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == n) return i;
        }
        return -1;
    }
}
