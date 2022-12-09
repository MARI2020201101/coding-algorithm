package ds.binarytree.sumbinarybit;

class SumRootToLeaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(0);
        Node left2 = new Node(0);
        Node left3 = new Node(0);
        root.left= left1;
        left1.left = left2;
        left2.left = left3;
        System.out.println(sumRootToLeaf(root));
    }
    static int sumRootToLeaf(Node root){
        return sumRootToLeaf(root, 0);
    }

    private static int sumRootToLeaf(Node root, int partialSum) {
        if(root == null){
            return partialSum;
        }
        if(root.left == null && root.right == null){
            return partialSum;
        }

        int leftSum = sumRootToLeaf(root.left,  partialSum*2 + root.data);
        int rightSum = sumRootToLeaf(root.right, partialSum*2 + root.data);
        System.out.println("leftSum = "+ leftSum);
        System.out.println("rightSum = "+ rightSum);
        return leftSum + rightSum;
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}