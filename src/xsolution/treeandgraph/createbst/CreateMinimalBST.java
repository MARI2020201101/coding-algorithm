package xsolution.treeandgraph.createbst;

import java.util.ArrayList;
import java.util.List;

class CreateMinimalBST {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node node = createMinimalBST(arr);
        node.print();
        List<List<Integer>> lists = createLevelTree(node);
        lists.forEach(System.out::println);
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

    static List<List<Integer>> createLevelTree(Node root){
        List<List<Integer>> lists = new ArrayList<>();
        return createLevelTree(root, 0, lists);
    }

    private static List<List<Integer>> createLevelTree(Node root, int level, List<List<Integer>> lists) {
        if(root ==null){
            return lists;
        }
        List<Integer> list = null;
        if(lists.size() == level){
            list = new ArrayList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root.data);
        createLevelTree(root.left, level+1, lists);
        createLevelTree(root.right, level+1, lists);

        return lists;
    }
}
