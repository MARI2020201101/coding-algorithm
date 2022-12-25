package xsolution.search;



class Ant {
    public Position position = new Position(0,0);
    public Orientation orientation = Orientation.right;

    public void turn(boolean clockwise){
        orientation = orientation.getTurn(clockwise);
    }
    public void move(){
        if(orientation == Orientation.left){
            position.column--;
        }else if(orientation == Orientation.right){
            position.column++;
        }else if(orientation == Orientation.up){
            position.row--;
        }else{
            position.row++;
        }
    }
    public void adjustPosition(int shiftRow, int shiftCol){
        position.row += shiftRow;
        position.column += shiftCol;
    }
}
class Position{
    public int row ;
    public int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
enum Orientation {
    left, up, right ,down;
    public Orientation getTurn(boolean clockwise){
        if(this == left){
            return clockwise ? up:down;
        }else if(this == up){
            return clockwise ? right : left;
        }else if(this == right){
            return clockwise ? down : up;
        }else{
            return clockwise ? left : right;
        }
    }
}