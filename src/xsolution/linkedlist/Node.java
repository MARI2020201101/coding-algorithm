package xsolution.linkedlist;

class Node {
    Integer data;
    Node next;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }
}
