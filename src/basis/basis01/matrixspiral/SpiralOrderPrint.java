package basis.basis01.matrixspiral;

class SpiralOrderPrint {
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
        for (int i = 0; i < length * length; i++) {
            if(x>=0 && y>=0 && x < length && y < length && arr[x][y]!=VISITED){
                System.out.print(arr[x][y] + " ");
                arr[x][y]=VISITED;
            }else{
                d++;
            }
            int nextX = x + next[d][0];
            int nextY = y + next[d][1];
            x = nextX;
            y = nextY;
            System.out.println(String.format("x=%d,y=%d",x,y));
        }
    }
}
