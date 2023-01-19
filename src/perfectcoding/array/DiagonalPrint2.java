package perfectcoding.array;

import java.util.ArrayList;

class DiagonalPrint2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20},
        };
        print(arr);
    }
    static void print(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>(n+m-1);
        for(int i = 0; i < n + m - 1; i++) {
            results.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                (results.get(i+j)).add(arr[i][j]);
            }
        }

        for (int i = 0; i < results.size(); i++) {
            for (int j = results.get(i).size() - 1; j >= 0; j--) {
                System.out.print(results.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
