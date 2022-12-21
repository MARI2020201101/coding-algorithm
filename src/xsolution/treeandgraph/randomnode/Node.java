package xsolution.treeandgraph.randomnode;


class Node {
    Integer data;
    Node left;
    Node right;
    Integer size = 0;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", size=" + size +
                '}';
    }

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node addData(Integer data){
        size++;
        if(this.data == null){
            this.data = data;
            return this;
        }else if(this.data >= data){
            if(this.left == null){
                left = new Node(data);
                return left;
            }else{
                left.addData(data);
            }
        }else{
            if(this.right == null){
                right = new Node(data);
                return right;
            }else{
                right.addData(data);
            }
        }
        return null;
    }
    public Node find(Integer data){
        if(this.data == null) return null;
        if(this.data == data){
            return this;
        }else if(this.data >= data){
            return left == null? null : left.find(data);
        }else{
            return right == null? null: right.find(data);
        }
    }
}
