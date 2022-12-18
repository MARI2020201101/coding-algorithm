package xsolution.treeandgraph.createbst;

class Node {
    Integer data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void print(){
        print(this);
    }
    public void print(Node node){
        if(node.left!=null){
            print(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right!=null){
            print(node.right);
        }
    }
}
