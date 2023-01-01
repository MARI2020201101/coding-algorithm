package ds.binarytree.balanced;

class IsBalanced {
    static BalanceStatusWithHeight isBalanced(Node root){
        if(root == null) return new BalanceStatusWithHeight(true, -1);

        BalanceStatusWithHeight leftResult = isBalanced(root.left);
        BalanceStatusWithHeight rightResult = isBalanced(root.right);

        if(! leftResult.balanced) return leftResult;
        else if(! rightResult.balanced) return rightResult;

        boolean result = Math.abs(leftResult.height - rightResult.height) <=1 ;
        int thisHeight = leftResult.height >= rightResult.height ? leftResult.height + 1: rightResult.height + 1;

        return new BalanceStatusWithHeight(result, thisHeight);
    }
}
