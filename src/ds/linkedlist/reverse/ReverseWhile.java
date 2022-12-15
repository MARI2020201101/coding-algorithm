package ds.linkedlist.reverse;

class ReverseWhile {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);
        System.out.println(head);

        Node last = reverse(head);
        System.out.println(last);
    }
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = head;
        while(curr != null){
            System.out.println(String.format("prev=%s, curr=%s, next=%s",prev,curr, next));
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
