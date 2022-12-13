package ds.queue.doublylinkedlist;
class Demo{
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(5);
        doublyLinkedList.insert(2);
        doublyLinkedList.insert(3);
        doublyLinkedList.insert(1);
        doublyLinkedList.insert(3);
        doublyLinkedList.insert(6);
        doublyLinkedList.insert(5);
        doublyLinkedList.print();
    }
}
class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList(){}
    DoublyLinkedList(Integer data) {
        head = new Node(data);
    }
    void print(){
        __print(head);
    }

    private void __print(Node node) {
        if(node == null) return;
        else{
            System.out.print(node.data + " ");
            __print(node.next);
        }
    }

    Node insert(Integer data){
        if(head == null){
            head = new Node(data);
            tail = new Node(null,head,null);
            head.next = tail;

            return head;
        }else{
            tail.data = data;
            tail.next = new Node(null,tail,null);
            tail = tail.next;
            return tail;
        }
    }
    Node delete(Integer data){
        return __delete(head, data);
    }

    private Node __delete(Node node, Integer data) {
        if(node == null) return new Node(null);
        if(node.data == data){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }else{
            __delete(node.next, data);
        }
        return node;
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
