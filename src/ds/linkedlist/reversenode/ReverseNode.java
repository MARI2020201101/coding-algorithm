package ds.linkedlist.reversenode;

class ReverseNode {
    static Node reverseNode(Node node, int start, int finish){
        if(start == finish ) return node;
        Node head = new Node();
        int k = 1;
        while (k++<start){
            head = head.next;
        }
        Node iterNode = head.next;
        while(start++ < finish){
            Node tmp = iterNode.next;
            iterNode.next = tmp.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }
}
class Node{
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}

