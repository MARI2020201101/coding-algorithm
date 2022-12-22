package basis.dp.dp03.maxmatrix;

class MaxMatrix {

    static int[][] arr = {
            {3,7,9,2,7},
            {9,8,3,5,5},
            {1,7,9,8,5},
            {3,8,6,4,10},
            {6,3,9,7,8},
    };

    public static void main(String[] args) {
        System.out.println(maxMatrix(arr));
    }
    static int maxMatrix(int[][] arr){
        int x = 0;
        int y = 0;
        int result = arr[x][y];
        while(true){
            int rightX = x+1;
            int rightY = y;

            int downX = x;
            int downY = y+1;
            int[] nextXY = move(rightX, rightY, downX, downY, result, arr);

            x = nextXY[0];
            y = nextXY[1];
            result = nextXY[2];

            if(x == arr[0].length-1 && y == arr.length-1) break;
        }

        return result;
    }

    private static int[] move(int rightX, int rightY, int downX, int downY, int result, int[][] arr) {
        if(rightX<0 || rightY< 0 || rightX>=arr[0].length || rightY>=arr.length) {
            result+=arr[downX][downY];
            return new int[]{downX, downY, result};
        }
        else if(downX<0 || downY< 0 || downX>=arr[0].length || downY>=arr.length) {
            result+=arr[rightX][rightY];
            return new int[]{rightX, rightY, result};
        }
        else{
            int nextX = arr[downX][downY] > arr[rightX][rightY] ? downX:rightX;
            int nextY = arr[downX][downY] > arr[rightX][rightY] ? downY:rightY;
            result += Math.max(arr[downX][downY], arr[rightX][rightY]);
            return new int[]{nextX, nextY, result};
        }
    }
}
