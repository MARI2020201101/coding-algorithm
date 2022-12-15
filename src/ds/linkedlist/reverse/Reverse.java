package ds.linkedlist.reverse;



class Reverse {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);
        System.out.println(head);

        Node last = reverse(head);
        System.out.println(last);
    }
    static Node reverse(Node head){
        if(head.next == null){
            return head;
        }

        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
class Node {
    Integer data;
    Node next;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }
    public Node addNext(Integer data){
        next = new Node(data);
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}