package xsolution.linkedlist;

class KthToLast {
    static Node kthToLast(Node head, int k){
        return kthToLast(head, k, new Index());
    }

    private static Node kthToLast(Node head, int k, Index index) {
        if(head == null){
            return null;
        }
        Node node = kthToLast(head.next, k, index);
        index.value = index.value + 1;
        if(index.value == k){
            return head; //뒤에서 K번째
        }
        return node;
    }
}
class Index {
    Integer value = 0;
}