package dp.dp03.maxmatrix;

class RecurMaxMatrix {

    static int[][] arr = {
            {3,7,9,2,7},
            {9,8,3,5,5},
            {1,7,9,8,5},
            {3,8,6,4,10},
            {6,3,9,7,8},
    };

    public static void main(String[] args) {
        System.out.println(maxMatrix(arr, 0, 0,0));
    }

    static int maxMatrix(int[][] arr, int i, int j, int value){
        if(!canMove(arr, i, j)) {
            return value;
        }
//
        int max = 0;
        max += Math.max(maxMatrix(arr, i+1,j, value+ arr[i][j]) , maxMatrix(arr, i, j+1, value+arr[i][j]));
        return max;
    }

    private static boolean canMove(int[][] arr, int i, int j) {
        return i>=0 && j>=0 && i<arr.length && j < arr[0].length;
    }


}
