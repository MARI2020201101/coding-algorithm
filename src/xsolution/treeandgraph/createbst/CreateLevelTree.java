package xsolution.treeandgraph.createbst;

import java.util.ArrayList;
import java.util.List;

class CreateLevelTree {
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
