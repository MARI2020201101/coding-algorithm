package xsolution.treeandgraph.createbst;

class CreateMinimalBST {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node node = createMinimalBST(arr);
        node.print();
    }

    static Node createMinimalBST(int[] arr){
        int len = arr.length;
        return __createMinimalBST(arr, 0, len-1);
    }

    private static Node __createMinimalBST(int[] arr, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Integer data = arr[mid];
        Node left = __createMinimalBST(arr, start, mid - 1);
        Node right = __createMinimalBST(arr, mid + 1, end);
        return new Node(data, left, right);
    }
}
