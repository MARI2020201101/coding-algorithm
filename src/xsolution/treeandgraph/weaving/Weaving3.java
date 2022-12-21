package xsolution.treeandgraph.weaving;

import java.util.ArrayList;
import java.util.LinkedList;

class Weaving3 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<LinkedList<Integer>> allSequences = allSequences(root);
        allSequences.forEach(System.out::println);
    }
    static ArrayList<LinkedList<Integer>> allSequences(Node node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if(node == null){
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);
        ArrayList<LinkedList<Integer>> firsts = allSequences(node.left);
        ArrayList<LinkedList<Integer>> seconds = allSequences(node.right);
        for (LinkedList<Integer> first : firsts) {
            for (LinkedList<Integer> second : seconds) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaved = weaveList(first, second, prefix, weaved);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static ArrayList<LinkedList<Integer>> weaveList(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> weaved) {
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(new LinkedList<>(prefix));
            result.addAll(new LinkedList<>(first));
            result.addAll(new LinkedList<>(second));
            weaved.add(result);
            return weaved;
        }

        Integer num = first.removeFirst();
        prefix.addLast(num);
        weaveList(first, second, prefix, weaved);
        prefix.removeLast();
        first.addFirst(num);

        Integer num2 = second.removeFirst();
        prefix.addLast(num2);
        weaveList(first, second, prefix, weaved);
        prefix.removeLast();
        second.addFirst(num2);

        return weaved;
    }
}
