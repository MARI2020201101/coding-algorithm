package xsolution.linkedlist;

class Partition2 {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.addNode(5).addNode(8).addNode(5).addNode(10).addNode(2).addNode(1);
        Node newHead = partition(node, 5);
        System.out.println(newHead);
    }
    static Node partition(Node node, Integer x){
        Node head = node;
        Node tail = node;

        while(node != null){
            Node next = node.next;
            if(node.data < x){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }
}
