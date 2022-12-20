package xsolution.treeandgraph.weaving;


import java.util.LinkedList;

class Weaving2 {
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

        LinkedList<LinkedList<Integer>> allSequences = allSequences(root, new LinkedList<>());
        allSequences.forEach(System.out::println);
    }
    static LinkedList<LinkedList<Integer>> allSequences(Node root, LinkedList<Integer> prefix){
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        if(root == null){
            result.add(prefix);
            return result;
        }
        prefix.add(root.data);
        LinkedList<LinkedList<Integer>> leftSequences = allSequences(root.left,prefix);
        LinkedList<LinkedList<Integer>> rightSequences = allSequences(root.right,prefix);
        System.out.println(leftSequences);

        for (LinkedList<Integer> first : leftSequences) {
            for (LinkedList<Integer> second : rightSequences) {
                LinkedList<LinkedList<Integer>> weaved = new LinkedList<>();
                weaveList(first, second, prefix, weaved);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, LinkedList<LinkedList<Integer>> weaved) {
        if(first.isEmpty() || second.isEmpty()){
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(prefix);
            result.addAll(first);
            result.addAll(second);
            weaved.add(result);
        }
        Integer firstOne = first.removeFirst();
        prefix.addLast(firstOne);
        weaveList(first, second, prefix, weaved);
        prefix.removeLast();
        first.addFirst(firstOne);

        Integer secondOne = second.removeFirst();
        prefix.addLast(secondOne);
        weaveList(first, second, prefix, weaved);
        prefix.removeLast();
        first.addFirst(secondOne);
    }
}
