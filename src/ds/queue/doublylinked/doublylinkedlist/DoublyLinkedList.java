package ds.queue.doublylinked.doublylinkedlist;

class Demo {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(5);
        doublyLinkedList.insert(2);
        doublyLinkedList.insert(3);
        doublyLinkedList.insert(1);
        doublyLinkedList.insert(6);
        doublyLinkedList.print();

        System.out.println("---");

        DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();
        doublyLinkedList2.insert(5);
        doublyLinkedList2.insert(2);
        doublyLinkedList2.insert(3);
        doublyLinkedList2.insert(1);
        doublyLinkedList2.delete(3);
        doublyLinkedList2.insert(6);
        doublyLinkedList2.delete(5);
        doublyLinkedList2.print();
    }
}
class DoublyLinkedList {
    Node curr;
    Node dummyHead;

    DoublyLinkedList(){
        Node nullNode = new Node(null, null, null);
        curr = nullNode;
        dummyHead = nullNode;
    }


    Node insert(Integer data){
        Node node = new Node(data);
        curr.next = node;
        node.prev = curr;
        curr = node;
        return node;
    }
    Node delete(Integer data){
        return __delete(dummyHead.next, data);
    }

    private Node __delete(Node node, Integer data) {
        if(node == null) return dummyHead;
        else if(node.data == data) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
        return null;
    }
    void print(){
        Node node = dummyHead.next;
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class Node {
    Integer data;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(Integer data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(Integer data) {
        this.data = data;
    }
}
