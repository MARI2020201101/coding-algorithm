package dp03.elevatorrides;

class ElevatorRides2 {
    static int maxWeight = 12;
    static int people = 5;
    static int[][] dp = new int[1<<people][2];
    // [i][0] = rides, [i][1] = weight
    static int[] weight = {2,3,4,5,9};
    static int minRides = Integer.MAX_VALUE;

    public static void main(String[] args) {
        minRides();
        print(dp);
    }
    static void minRides(){
        for (int i = 0; i < (1<<people); i++) {
            for (int j = 0; j < people; j++) {
                if((i&(1<<j))==0){
                    int option1 = dp[i^(1 << j)][0];
                    int option2 = dp[i^(1 << j)][1];
                    System.out.println(String.format("i=%d,j=%d,i^(1<<j)=%d,option1=%d,option2=%d",i,j,i^(1 << j),option1,option2));
                    if(dp[i][1]+weight[j]<=maxWeight){
                        dp[i][1]+=weight[j];
                    }else{
                        dp[i][0]+=1;
                        dp[i][1] = weight[j];
                    }
                    minRides = Math.min(minRides, dp[i][0]);
                }
            }
        }
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+i+"] ");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
