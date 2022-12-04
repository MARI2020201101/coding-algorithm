package ds.linkedlist.reverseall;

class ReverseWhile {
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.addNode(2).addNode(3).addNode(4).addNode(5);
        System.out.println(head.toString());

        ListNode2 last = reverse(head);
        System.out.println(last.toString());
    }
    static ListNode2 reverse(ListNode2 head){
        ListNode2 pre, cur, nxt;
        pre = null; cur = head ; nxt = head;
        while(cur!=null){
            System.out.println(String.format("pre=%s, cur=%s, nxt=%s",pre,cur,nxt ));
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
class ListNode2{
    int data;
    ListNode2 next;

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                "}";
    }

    public ListNode2(int data) {
        this.data = data;
    }
    public ListNode2 addNode(int data){
        this.next = new ListNode2(data);
        return next;
    }
}
