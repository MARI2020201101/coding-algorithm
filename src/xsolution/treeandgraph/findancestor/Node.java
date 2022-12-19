package xsolution.treeandgraph.findancestor;

class Node {
    Integer data;
    Node left;
    Node right;
    Node parent;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
