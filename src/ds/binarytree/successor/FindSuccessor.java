package ds.binarytree.successor;

class FindSuccessor {

    static Node findSuccessor(Node node){
        Node iter = node;
        if(iter.right !=null){
            iter = iter.right;
            while(iter!=null &&iter.parent.left == iter){
                iter = iter.left;
            }
            return iter;
        }
        while(iter.parent!=null && iter.parent.right == iter){
            iter = iter.parent;
        }
        return iter.parent;

    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int data) {
        this.data = data;
    }
}