package ds.binarytree.kthnode;

class KthNode {
    static Node kthNode(Node root, int k){
        Node iter = root;
        while (iter!=null){
            int leftSize = iter.left != null? iter.left.size : 0;
            if(leftSize+1 == k){
                return iter;
            }else if(leftSize+1 < k){
                k-=(leftSize+1);
                iter = iter.right;
            }else{
                iter = iter.left;
            }
        }
        return iter;
    }
}
class Node{
    int data;
    int size;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}