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
    public Node addNode(Integer data){
        Node node = new Node(data);
        this.next = node;
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
