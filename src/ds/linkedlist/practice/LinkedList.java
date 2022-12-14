package ds.linkedlist.practice;

class LinkedList {
    Node head;
    Node curr;

    LinkedList(){
        head = curr = null;
    }
    boolean isEmpty(){
        return head == null;
    }
    Node search(Integer data){
        Node node = head;
        while(node!=null){
            if(node.data == data) return node;
            node = node.next;
        }
        return null;
    }
    Node addFirst(Integer data){
        Node prev = head;
        head = curr = new Node(data, prev);
        return head;
    }
    Node addLast(Integer data){
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        node.next = curr = new Node(data, null);
        return curr;
    }
    Node removeFirst(){
        if(head == null) return null;
        Node target = head;
        head = curr = head.next;
        return target;
    }
    Node removeLast(){
        if(head.next==null){
            Node target = head;
            head = curr = null;
            return target;
        }
        Node node = head;
        while(node.next.next != null){
            node = node.next;
        }
        Node target = node.next;
        node.next = null;
        curr = node;
        return target;
    }
    Node remove(Integer data){
        Node node = head;
        Node prev = null;
        if(head.data == data){
            Node target = head;
            head = curr = null;
            return target;
        }
        while(node != null){
            if(node.data == data) {
                prev.next = node.next;
                curr = prev;
                return node;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
}
class Node{
    Integer data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }
}