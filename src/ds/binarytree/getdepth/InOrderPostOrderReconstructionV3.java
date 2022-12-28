package ds.binarytree.getdepth;

class InOrderPostOrderReconstructionV3 {
    static StringBuilder sb = new StringBuilder();
    static int[] inOrder = {4 ,2, 7, 5, 1, 3, 6};
    static int[] postOrder = {4, 7, 5, 2, 6, 3, 1 };
    public static void main(String[] args) {
        int N = inOrder.length;
        getPreOrder(0, N - 1, 0, N - 1);
        System.out.println(sb.toString());//preOrder 출력
    }
    public static void getPreOrder(int in_start, int in_end, int p_start, int p_end)  {
        if (in_start > in_end || p_start > p_end)
            return;

        int root = postOrder[p_end];
        sb.append(root + " ");

        int rootIdx =  find(inOrder, root);
        int left = rootIdx - in_start;

        getPreOrder(in_start, rootIdx - 1, p_start, p_start + left - 1);
        getPreOrder(rootIdx + 1, in_end, p_start + left, p_end - 1);
    }

    static int find(int[] inOrder, int n){
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == n) return i;
        }
        return -1;
    }
}
