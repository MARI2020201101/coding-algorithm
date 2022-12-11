package basis.basis01.matrixspiral;

class SpiralOrderPrint2 {
    static int VISITED = -1;
    static int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16},
    };
    static int[][] next ={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0},
    };

    public static void main(String[] args) {
        print(arr);
    }
    static void print(int[][] arr){
        int length = arr.length;
        int x = 0;
        int y = 0;
        int d = 0;
        int nextL = next.length;
        for (int i = 0; i < length * length; i++) {
            System.out.print(arr[x][y] + " ");
            arr[x][y]=VISITED;
            int nextX = x + next[d][0];
            int nextY = y + next[d][1];
            if(nextX<0 || nextY<0 || nextX >= length || nextY >= length || arr[nextX][nextY]==VISITED){
                d=(d+1)%nextL;
                nextX = x + next[d][0];
                nextY = y + next[d][1];

            }
            x = nextX;
            y = nextY;
//            System.out.println(String.format("x=%d,y=%d",x,y));
        }
    }
}
