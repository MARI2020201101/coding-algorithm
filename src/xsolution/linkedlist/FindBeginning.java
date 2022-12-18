package xsolution.linkedlist;

class FindBeginning {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node begin = new Node(999);
        head.addNode(2).addNode(3).addNode(4).addNode(5).next = begin;
        begin.next = head;

        System.out.println(findBeginning(head));
    }
    static Node findBeginning(Node head){
        Node slow = head;
        Node fast = head;

        while(slow!=null && fast!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
