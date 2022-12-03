package ds.linkedlist.reverseall;

import org.w3c.dom.Node;

class Reverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2).addNode(3).addNode(4).addNode(5);
        System.out.println(head.toString());

        ListNode last = reverse(head);
        System.out.println(last.toString());
    }
    static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        System.out.println("last="+ last);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
class ListNode{
    int data;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public ListNode(int data) {
        this.data = data;
    }
    public ListNode addNode(int data){
        this.next = new ListNode(data);
        return next;
    }
}
